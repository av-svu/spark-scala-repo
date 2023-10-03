package com.pw.deb.scala.sandbox

trait Cloader extends DwhJob {

  val b: Int = 20

  println("cloader trait field " + b)

  test()

  override def test(): Unit ={
    println("cloader trait function " + b)

  }

}
