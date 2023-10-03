package com.pw.deb.scala.sandbox

import scala.util.Random

object P7MatchCase {

  def main(args: Array[String]): Unit = {

    val data = (Random.nextInt(2),Random.nextInt(2))
    println(data)

    data._1%2 match {
      case 0 => println(s"${data._1}=zero")
      case 1 => println(s"${data._1}=one")
      case _ => println(s"${data._1}=something else")
    }

    val result = (data._1,data._2) match {
      case (0,0) => ("zero","zero")
      case (0,1) => ("zero","one")
      case (1,0) => ("one","zero")
      case (1,1) => ("one","one")
      case _ => ("other","other")
    }
    println(result)

    val interval = for (i <- 1 to 10) yield {
      i match {
        case 1 if(i+10 == 20) => s"case $i condition"
        case 5 if(i+10 ==20) => s"case $i condition"
        case 10 if(i+10 ==20) => s"case $i condition"
        case _ => s"default case $i"
      }
    }

    print(interval)



  }

}
