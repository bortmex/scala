package com.rog.teach.simple.stepik.exercises.week1basics

//Это объясняется разницей в подходах к вычислению значений параметров.
//Вызов по значению подразумевает вычисление значения переданного выражения перед вызовом функции.
//Преимущество: значение вычисляется только один раз.
//Вызов по имени подразумевает вычисление значения выражения в момент его вызова в функции
//Преимущество: значение не вычисляется, если не используется в теле функции.
object Solution1 extends App {
  def someFunc(): Int = 2 * someFunc() + 1
  //def callSomeFunc(x: Int, y: Int) = println(x) //->java.lang.StackOverflowError
  def callSomeFunc(x: Int, y: => Int) = println(x)

  callSomeFunc(1, someFunc())
}
