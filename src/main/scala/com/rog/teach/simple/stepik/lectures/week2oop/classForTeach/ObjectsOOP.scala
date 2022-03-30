package com.rog.teach.simple.stepik.lectures.week2oop.classForTeach

object ObjectsOOP extends App {
  object Number {
    val Pi = 3.14
  }

  println(Number.Pi)


  class MyString(val str: String) {
    private var extra = "extraData"

    def getString: String = str + extra
  }

  object MyString {
    def apply(base: String, extras: String): MyString = {
      val s = new MyString(base)
      s.extra = extras
      s
    }

    def apply(base: String) = new MyString(base)
  }

  println(MyString.apply("hello", "world").getString)
  println(MyString.apply("welcome").getString)

  class Number(val num: Int) {

    object Number {
      val Pi = 3.14

      def apply(x: Number, y: Number): Number = new Number(x.num + y.num)
    }

    val numA = new Number(1)
    val numB = new Number(2)

    val numC: Number = Number(numA, numB) // применяем apply

    println(numA.num) // 1
    println(numB.num) // 2
    println(numC.num) // 3
  }

}