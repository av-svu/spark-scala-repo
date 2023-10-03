package com.pw.deb.scala.sandbox

object P6ForLoop {

  def main(args: Array[String]): Unit = {

    println("0 to 10 - 10 included")
    for (i <- 0 to 10) {
      print(s"$i ")
    }
    println()
    println("0 until 10 - 10 excluded")
    for (i <- 0 until 10) {
      print(s"$i ")
    }
    println()
    println("for with if. print even numbers")
    for (i <- 0 to 10 ; if(i%2==0)) {
      print(s"$i ")
    }

    println()
    println("for with if multi line syntax. print even numbers")
    for {
      i <- 0 to 10
      if(i%2==0)
    }      {
        print(s"$i ")
      }

    println()
    println("nested for with if. yield result as touple and then print")
    val vector = for {
      l <- 'a' to 'c'
      n <- 1 to 10
      if(n%2==0)
    } yield {
      l -> n
    }
    println(vector)

  }

}
