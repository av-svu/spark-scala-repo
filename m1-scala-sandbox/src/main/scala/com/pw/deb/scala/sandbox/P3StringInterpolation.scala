package com.pw.deb.scala.sandbox

object P3StringInterpolation {
  println("built-in constructor start")
  val name: String = "john"
  var age: Int = 25

  def main(args: Array[String]): Unit = {

    println("main method start")
    val age: Int = 20
    // age+=1 throws error. can't update val. use var

    val msg1: String = name + " is " + age + " years old"
    println(msg1)

    println("main method end")
  }

  age+=1
  println("string interpolation using $")
  val msg2: String = s"$name is $age years old"
  println(msg2)

  val msg3: String = s"$name is ${age+1} years old by next year"
  println(msg3)
  println("built-in constructor end")
}
