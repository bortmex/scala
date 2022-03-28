package com.rog.teach.simple.stepik.lectures.week1basics

object TypesValuesVariables extends App {

  var aString : String = "Hi"
  println(aString)
  aString += " Alexander"
  println(aString)

  val aInt = 10 ; val aLong = 10L
  println(aInt.getClass)
  println(aLong.getClass)
}
