package com.pw.deb.spark.sandbox

import org.apache.spark.sql.{SparkSession}
import java.io.File


class UtilSparkSession {

  def createSparkSession(appName: String): SparkSession = {
    println("set hadoop home using env var")
    System.setProperty("hadoop.home.dir", System.getenv("HADOOP_HOME"))
    val sparkWHDir = new File("spark-warehouse").getAbsolutePath
    val spark = SparkSession
      .builder()
      .appName(name = appName)
      .config("spark.master", "local")
      .config("spark.sql.warehouse.dir", sparkWHDir)
      .config("spark.sql.legacy.allowCreatingManagedTableUsingNonemptyLocation", "true")
      .getOrCreate()
    spark
  }
}
