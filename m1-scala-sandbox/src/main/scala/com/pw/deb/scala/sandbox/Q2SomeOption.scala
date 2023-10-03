package com.pw.deb.scala.sandbox

import scala.util.Random

object Q2SomeOption {
  def main(args: Array[String]): Unit = {

    val arr = Array.fill(20)(Random.nextInt(50))

    for (i<-arr) {
      print(s"$i ")
    }

    println("return type should be Some or None which extends Option")

    println(arr.find(_<2))

    println(arr.find(i=>i>15))

    println(arr.find(i=>i>100))

    println(arr.find(_>2).getClass.getName)

    println("match result")

    val i=arr.find(_<5)

    val res1 = i match {
      case Some(i) => i
      case None => 0
    }
    println(res1)
    println("using getOrElse")
    println(i.getOrElse(0))



  }

}
