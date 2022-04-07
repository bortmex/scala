package com.rog.teach.simple.stepik.lectures.week3fp

object Collections extends App {
  val aSequence = Seq(1,3,2,4)
  println(aSequence.search(567))

  println(List(("White", "#FFFFFF")).toMap)


  val progLanguages = List("java", "scala", "python")


  progLanguages.map(_.toUpperCase).foreach(print)
}
