package com.rog.teach.simple.stepik.exercises.week2oop

object Solution7 extends App {

  class Logger(msgNum: Int = 0) {

    val count: Int = msgNum

    def info: Logger = {
      println("INFO New Message")
      new Logger(msgNum + 1)
    }

    def info(n: Int): Logger = {
      if (n <= 0) {
        this
      }
      else info.info(n - 1)
    }

    def print: Unit = {
      println(count)
    }
  }

  val log = new Logger()
  println(log.count)
}
