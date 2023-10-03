package com.pw.deb.scala.sandbox

object P5IfElseWhile {
  def main(args: Array[String]): Unit = {
    print("enter a number: ")
    val num: Int = scala.io.StdIn.readInt()

    //if else
    if(num%2==0) {
      println(s"$num is even number")
    }
    else{
      println(s"$num is odd number")
    }


    // if else easy syntax

    if (num%2==0) println(s"syntax1- $num is even") else println(s"syntax1- $num is odd")
    println(if(num%2==0) s"syntax2- $num is even" else s"syntax2- $num is odd")
    val result = if(num%2==0) s"syntax3- $num is even" else s"syntax3- $num is odd"
    println(result)


    // if else if. use match for this kind of stuff
    if (num > 0) {
      println(s"$num is greater than zero")
    }
    else if (num < 0) {
      println(s"$num is less than zero")
    }
    else {
      println(s"$num is zero")
    }


    // while loop
    var i: Int=0
    while(i<10) {
      print(s"$i ")
      i+=1
    }
  }
}
