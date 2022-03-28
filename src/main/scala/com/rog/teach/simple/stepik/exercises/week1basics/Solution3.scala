package com.rog.teach.simple.stepik.exercises.week1basics

import scala.annotation.tailrec


//Попрактикуемся еще, чтобы уж точно набить руку.
//
//От вас требуется написать программу, которая:
//
//  увеличивает заданное число x на число y n-ое количество раз
//  выводит на экран полученное на шаге 1 число столько раз, сколько в нем цифр, и фразу is the result
//  Замечания:
//
//  в этот раз имплементация принта конечного результата на вас
//  давайте ограничимся целыми числами Int
//  обратиться к входным аргументам (они уже заданы и доступны для использования) можно через fArgs(0), fArgs(1) и fArgs(2), что соответствует x, y и n (не забудьте вызвать написанную вами функцию, передав ей на вход требуемые аргументы)
//  прописывать def main(args: Array[String]) не надо - это сделано за вас, можете сразу начинать писать свой код к заданию
//  постарайтесь обойтись без использования var и циклов while, данную программу можно и нужно написать, используя только хвостовую рекурсию, ведь именно ее мы отрабатываем
//

object Solution3 extends App {

  def xAddYNnumbers(x: Int, y: Int, n: Int): Unit = {

    def incremen(start_num: Int, y: Int, n: Int): Int = {
      @tailrec
      def loop(x1: Int, accumulator: Int = start_num): Int = {
        if (x1 == 0) accumulator
        else loop(x1 - 1, accumulator + y)
      }

      loop(n)
    }

    def printResult(print_num: Int): Unit = {
      @tailrec
      def loop(x: Int = print_num.toString.length, acc: String = ""): String = {
        if (x == 0) s"${acc}is the result"
        else loop(x - 1, s"${print_num.toString} $acc")
      }

      println(loop())
    }

    printResult(incremen(x, y, n))
  }

  xAddYNnumbers(100, 1, 5)
}
