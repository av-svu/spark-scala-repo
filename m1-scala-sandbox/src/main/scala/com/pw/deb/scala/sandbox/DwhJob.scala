package com.pw.deb.scala.sandbox

trait DwhJob {

  val a:Int = 10

  println("dwhjob trait field " + a)

  test()

  def test(): Unit = {
    println("dwhjob trait function " + a)

  }


}
