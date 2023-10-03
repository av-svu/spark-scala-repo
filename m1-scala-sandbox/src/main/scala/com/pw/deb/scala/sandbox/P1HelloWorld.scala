package com.pw.deb.scala.sandbox

class P1HelloWorld {


  def addTwoInt(num1: Int, num2: Int): Int = {
    num1 + num2
  }

  def getScalaVersion: String = util.Properties.versionString

}

object P1HelloWorld   {
  def main(args: Array[String]): Unit = {

    val obj = new P1HelloWorld()
    println("Hello world from scala:" + obj.getScalaVersion)
    println("sum of 10 and 20 is= ",obj.addTwoInt(10,20))
  }



}
