package com.pw.deb.scala.sandbox

object P4LambdaExpressions {

  def main(args: Array[String]): Unit = {

    val square1 = (x:Int)=> x*x
    println(square1(10))
    // can be written as follows which is better
    val square2: Int => Int = x => x*x
    println(square2(25))

    val twice1: Int => Int = x => x*2
    println(twice1(10))
    // can be written using anonymous variables _ depending on # of input variables
    val twice2: Int => Int = _*2
    println(twice2(20))

    val isLessThan1: (Int,Int) => Boolean = (x,y) => x<y
    println(isLessThan1(5,10))
    // can be written as follows. since two inputs so two _
    val isLessThan2: (Int,Int) => Boolean = _<_
    println(isLessThan2(20,10))

  }
}
