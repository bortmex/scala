package com.rog.teach.simple.stepik.lectures.week1basics

object Functions extends App{
  def aFunctionWithDefaultParameter(x: Int = 11, y: String = "Default Parameter"): String = {
    s"x = $x and y = $y"
  }
  println(aFunctionWithDefaultParameter(1))

  def callByValue(x: Long): Unit = {
    println(s"call by value: x1 = $x")
    println(s"call by value: x2 = $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"call by name: x1 = $x")
    println(s"call by name: x2 = $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def aBossFunction(): String = {
    def aHelperFunction(): String = "I'm here to help"

    aHelperFunction()
  }

  // исправьте код
  def aCondition(): Boolean = if (1 > 2) true else false

  def someFunnc(x: Int, y: Int): Int = {
    x * 2
  }
  println(someFunnc(3, 4))
}
