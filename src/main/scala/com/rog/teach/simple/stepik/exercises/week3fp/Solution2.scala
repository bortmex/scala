package com.rog.teach.simple.stepik.exercises.week3fp

object Solution2 extends App{
  val progLanguages = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")

  val out = progLanguages.flatMap(lng => lngAbbrev.filter(abrv => lng.substring(0,1).equals(abrv.substring(0,1).toLowerCase)).map(abrv => (abrv, lng)))

  println(out)

}
