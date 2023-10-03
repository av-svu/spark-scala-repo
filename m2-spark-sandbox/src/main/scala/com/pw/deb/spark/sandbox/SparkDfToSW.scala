package com.pw.deb.spark.sandbox

import org.apache.spark.sql.{SparkSession,DataFrame,SaveMode}

object SparkDfToSW {
  def main(args: Array[String]): Unit = {

    val sparkWHTbl = "sampleseq"

    println("create spark session")
    val appName = this.getClass.getName
    val sparkUtil = new UtilSparkSession()
    val spark = sparkUtil.createSparkSession(appName)
    val tdb="prod"


    println("create dataframe")
    val sdf = getDF(spark)

    println("get source count")
    getDFCnt(sdf)


    println("write to spark warehouse")
    writeToTarget(spark,sdf,sparkWHTbl,tdb)

    println("get target count")
    val tdf = readFromTarget(spark,sparkWHTbl,tdb)
    getDFCnt(tdf)

    println("show results from table")
    showDFData(tdf)

    spark.stop()

  }


  def getDF(spark: SparkSession): DataFrame = {
    val sampleSeq = Seq((1, "hadoop"), (2, "hive"), (3, "spark"))
    spark.createDataFrame(sampleSeq).toDF(colNames = "id", "course")

  }

  def getDFCnt(dataFrame: DataFrame): Long = {
    val cnt = dataFrame.count()
    println("count= ", cnt)
    cnt
  }

  def showDFData(dataFrame: DataFrame): Unit = {
    dataFrame.show(10)
  }

  def writeToTarget(spark:SparkSession,dataFrame: DataFrame, tblName: String,db: String): Unit = {
    spark.sql("CREATE DATABASE IF NOT EXISTS "+db)
    dataFrame.write
      .mode(SaveMode.Overwrite)
      .saveAsTable(db+"."+tblName)
  }

  def readFromTarget(spark:SparkSession, tblName:String,db: String): DataFrame = {
    spark.read
      .table(db+"."+tblName)
  }

}
