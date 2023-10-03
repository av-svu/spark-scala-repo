package com.pw.deb.spark.sandbox

import org.apache.spark.sql.{SparkSession,DataFrame,SaveMode}

import java.io.File

object SparkOraToSW {
  def main(args: Array[String]): Unit = {

    println("set hadoop home using env var")
    System.setProperty("hadoop.home.dir", System.getenv("HADOOP_HOME"))

    println("create spark session")
    val sparkWHDir = new File("spark-warehouse").getAbsolutePath
    val spark=createSparkSession(sparkWHDir)

    println("read data from oracle")
    val propsObj = new UtilProperties()
    val oraDF = readFromOracle(spark, propsObj)

    println("write data to spark warehouse. number of rows= " + oraDF.count())
    val sparkWHTbl:String = "calendar"
    writeToSparkWH(oraDF,sparkWHTbl)

    println("show results from table")
    showSparkWHTblData(spark, sparkWHTbl)

    println("all done")
    spark.stop()
  }

  def createSparkSession(sparkWHDir: String): SparkSession = {
      val className = this.getClass.getName
      val spark = SparkSession
        .builder()
        .appName(name = className)
        .config("spark.master", "local")
        .config("spark.sql.warehouse.dir", sparkWHDir)
        .config("spark.sql.legacy.allowCreatingManagedTableUsingNonemptyLocation", "true")
        .getOrCreate()
      spark
    }

  def readFromOracle(spark: SparkSession, propsObj: UtilProperties): DataFrame = {
    val properties = propsObj.getProperties("m2-spark-basics/src/main/resources/dev.properties")
    val dbUrl = properties.getProperty("source.dbUrl")
    val dbUsername = properties.getProperty("source.dbUser")
    val dbPassword = properties.getProperty("source.dbPassword")
    val dbDriver = properties.getProperty("source.dbDriver")
    val dbTbl = properties.getProperty("source.dbTbl")

    val oraDF = spark.read
      .format("jdbc")
      .option("url", dbUrl)
      .option("user", dbUsername)
      .option("password", dbPassword)
      .option("driver", dbDriver)
      .option("dbtable", dbTbl)
      .load()

    oraDF
  }

  def writeToSparkWH(dataFrame: DataFrame,sparkWHTbl: String): Unit = {
    dataFrame.write
    .mode(SaveMode.Overwrite)
      .partitionBy("fiscal_year","fiscal_year_quarter","fiscal_year_month")
    .saveAsTable(sparkWHTbl)
  }

  def showSparkWHTblData(spark: SparkSession, sparkWHTbl: String): Unit = {
    val df = spark.read.table(sparkWHTbl)
    df.show(10)
  }

}
