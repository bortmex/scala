package com.rog.teach.simple.stepik2.exercises.week1
//Известно следующее:
//
//  есть программа, на вход которой подается строка
//  если передать программе слово hi, то в результате будет выведено: Say something:Say something:hihi
//  нам же требуется, чтобы программа выводила: Say something:hihi
//  Исправьте код так, чтобы был получен желаемый результат, не меняя при этом строчку кода с
//  def showString(someStr: => String): Unit

//  def showString(someStr: => String): Unit = {
//  print(s"$someStr$someStr")
//  }
object Solution8 extends App {

  def say(str: String): String = {
    print("Say something:")
    str
  }

  def showString(someStr: => String): Unit = {
    lazy val lazyVal = someStr
    print(s"$lazyVal$lazyVal") //// -> Say something:hihi
    //print(s"$someStr$someStr")// -> Say something:Say something:hihi
  }

  showString(say("hi"))
}
