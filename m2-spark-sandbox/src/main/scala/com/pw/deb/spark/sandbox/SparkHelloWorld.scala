package com.pw.deb.spark.sandbox

import org.apache.spark.sql.{SparkSession,DataFrame,SaveMode}

object SparkHelloWorld {

  def main(args: Array[String]): Unit = {

    println("create spark session")
    val appName = this.getClass.getName
    val sparkUtil = new UtilSparkSession()
    val spark = sparkUtil.createSparkSession(appName)

    println("create data frame")
    val dataFrame = createDF(spark)
    showDF(dataFrame)

    println("show spark config")
    val printConfig = new UtilSparkConfig()
    printConfig.showSparkConfig(spark)

    spark.stop()
  }


  def createDF(spark: SparkSession): DataFrame = {
    val tempSeq = Seq((1, "hadoop"), (1, "spark"))
     spark.createDataFrame(tempSeq).toDF(colNames = "id", "topic")
  }

  def showDF(dataFrame: DataFrame): Unit = {
    dataFrame.show()
    dataFrame.printSchema()

  }

}
