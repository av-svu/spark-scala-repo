package com.pw.deb.spark.sandbox

import org.scalatest.FlatSpec


class SparkDfToSWSpec extends FlatSpec{

  behavior of "Spark dataframe to spark warehouse"

  println("create spark session")
  val appName = this.getClass.getName
  val sparkUtil = new UtilSparkSession()
  val spark = sparkUtil.createSparkSession(appName)
  val sparkWHTbl = "sampleseq"
  val tdb = "test"


  val sdf = SparkDfToSW.getDF(spark)
  it should "extract some rows from source" in {
    assert(sdf.count()>0)
  }

  SparkDfToSW.writeToTarget(spark,sdf,sparkWHTbl,tdb)
  it should "insert some rows into target" in {
    val tdf = SparkDfToSW.readFromTarget(spark,sparkWHTbl,tdb)
    assert(tdf.count()>0)
  }


}
