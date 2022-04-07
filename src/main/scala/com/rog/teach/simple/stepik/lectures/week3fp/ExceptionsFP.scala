package com.rog.teach.simple.stepik.lectures.week3fp

import scala.annotation.tailrec

object ExceptionsFP extends App{
  @tailrec
  def nTimes(f: Int => Int, x: Int,  n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }
  val increment = (x: Int) => x + 1

  println(nTimes(increment, 0, 3))

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n-1)(f(x))
  }

  println(curryingNTimes(increment, 3)(0))

  def createURL(baseURL: String, path: String) = s"https://${baseURL}/${path}"

  createURL("stepik.org", "login" )
  createURL("stepik.org", "contact" )
  createURL("mail.google.com", "login")

  def createURL(baseURL: String) = (path: String) => s"https://${baseURL}/${path}"

  val stepikURL =  createURL("stepik.org")
  val googleURL = createURL("mail.google.com")

  stepikURL("login")
  stepikURL("contact")

  googleURL("login")


//  тип A => B - это синоним типа Function1[A, B]
//  тип (A1, A2) => B - синоним для Function2[A1, A2, B]
//  A => B => C - это то же самое, что Function1[A, Function1[B, C]]
  def someFunc = (x:Int) => (y: Int) => x + y


  def someFunc1: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val res = someFunc1(1)
  println(res)
}
