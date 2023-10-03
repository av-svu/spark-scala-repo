package com.pw.deb.scala.sandbox

object Q1TryCatch {
  def main(args: Array[String]): Unit = {

    val str2 = "123a"
    val num2 = try {
      str2.toInt
    } catch {
      case ex: NumberFormatException => 0
    }

    println(num2)

    // using lambda expression
    val str2Num: (String => Int) = str => try {
      str.toInt
    } catch {
      case exception: NumberFormatException => 0
    }

    println(str2Num("10245"))
    println(str2Num("10a01"))

  }
}
