package com.rog.teach.simple.stepik.lectures.week3fp

object Collections extends App {
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence.search(567))

  println(List(("White", "#FFFFFF")).toMap)


  val progLanguages = List("java", "scala", "python")


  progLanguages.map(_.toUpperCase).foreach(print)

  println()
  println(Seq(3, 4, 3, 3).sorted.search(3))


  case class Tray(x: Int, y: String) {
    override def toString: String = s"${x} ${y}"
  }


  val sampleTuple = new Tuple2(2, "Hello, World")
  println(sampleTuple.copy(_2 = "Scala").swap._1 + 5) // => Scala5

  val map = Map(1 -> "Qwe", 2 -> "45")
  map.filter((entry: (Int, String)) => entry._1 < 2).foreach(print)

}
