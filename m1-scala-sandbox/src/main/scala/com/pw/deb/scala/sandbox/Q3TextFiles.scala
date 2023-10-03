package com.pw.deb.scala.sandbox

import scala.io.Source

object Q3TextFiles {
  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("pom.xml")
    val lines = source.getLines()
    /*
    for (line<-lines) {
      println(line)
    }
    */

    val words = lines.map(line=>line.split(" "))

    val wordsArr = words.toArray

    source.close()

    for (word <- wordsArr){
      println(word.getClass.getName)
      println(word.foreach(println))
    }

  }

}
