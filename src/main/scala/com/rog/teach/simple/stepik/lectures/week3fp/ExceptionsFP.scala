package com.rog.teach.simple.stepik.lectures.week3fp

import scala.util.Try

object ExceptionsFP extends App{

  def unsafeMethod(): String = throw new RuntimeException("Sorry, not your day")

  val anotherPotentialFailure = Try {
    Try(unsafeMethod())
    "another failure"
  }

  println(anotherPotentialFailure)



  //def firstMethod(): Try[String] = Try(new RuntimeException("Ooops..."))
  def firstMethod(): Try[RuntimeException] = Try(new RuntimeException("Ooops..."))

  def secondMethod(): Try[String] = Try("Everything is OK")

  val res = firstMethod() orElse secondMethod()

  println(res)
}
