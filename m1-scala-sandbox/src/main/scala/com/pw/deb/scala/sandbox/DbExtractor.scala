package com.pw.deb.scala.sandbox

class DbExtractor extends Cloader {

  val c:Int = 30

  println("dbextractor trait field " + c)

  test()
  override def test():Unit = {
    println("dbextractor trait function" + c)
  }

}

object DbExtractor{

  def main(args: Array[String]): Unit = {
    println("from main")
    val obj = new DbExtractor()
    println("calling dbextractor test")
    obj.test()
  }
}
