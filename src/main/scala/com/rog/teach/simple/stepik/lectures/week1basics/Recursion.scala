package com.rog.teach.simple.stepik.lectures.week1basics
import scala.annotation.tailrec

object Recursion extends App {
  //Хвостовая рекурсия (Tail Recursion)
  def factorialWithTailRecursion(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else loop(x-1, x*accumulator)
    }

    loop(n, 1)
  }

}
