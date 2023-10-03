package com.pw.deb.scala.sandbox

object P2VariablesAndTypes {
  println("built-in constructor start")

  // val variables can't be updated. var variables can be updated
  val str1 = "some string1-"
  val str2: String = "some string2-"

  val num1 = 5
  val num2: Int = 10

  val flag1 = true
  val flag2: Boolean = false

  val tuple1 = (str1,num1,flag1)

  println("built-in constructor end")

  def main(args: Array[String]): Unit = {

    println("main method start - print constructor values ")
    println(str1+str2)
    println(num1+num2)
    println(flag1||flag2)
    println(tuple1._1+tuple1._2+tuple1._3)
    println("main method end")


  }
}
