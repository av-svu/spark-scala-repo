package com.pw.deb.scala.sandbox

import org.scalatest.FlatSpec


class P1HelloWorldSpec extends FlatSpec {


  behavior of "spark hello world program"

  val obj = new P1HelloWorld()

  it should "return correct sum of two ints" in {

    assert(obj.addTwoInt(5,10)==15)

  }

}
