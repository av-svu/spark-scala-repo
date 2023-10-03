package com.pw.deb.spark.sandbox

import org.apache.spark.sql.SparkSession


class UtilSparkConfig {

  def showSparkConfig (spark: SparkSession): Unit = {
    val sparkConf = spark.sparkContext.getConf.getAll
    sparkConf.foreach { case (k, v) => println(s"$k=$v") }

  }

}
