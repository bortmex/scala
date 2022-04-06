package com.rog.teach.simple.stepik.exercises.week2oop

object Solution9 extends App{
  abstract class LogList[+A] {
    def add[B >: A](msg: B): LogList[B]

    def previous: LogList[A]

    def last: A

    def all: String

    def isEmpty: Boolean
  }

  object Empty extends LogList[Nothing] {
    override def add[Nothing](msg: Nothing): LogList[Nothing] = new Log(msg, Empty)
    //def add[B >: Nothing](msg: B): LogList[B] = new Log(msg, Empty)

    override def previous: LogList[Nothing] = throw new NoSuchElementException

    override def last: Nothing = throw new NoSuchElementException

    override def all: String = ""

    override def isEmpty: Boolean = true
  }

  class Log[+A](head: A, tail: LogList[A]) extends LogList[A] {
    override def add[B >: A](msg: B): LogList[B] = new Log(msg, this)

    override def previous: LogList[A] = tail

    override def last: A = head

    override def all: String = {
      def checkAll(list: LogList[A]): String = {
        if (list.isEmpty) list.last.toString else s"${list.last} ${checkAll(list.previous)}"
      }
      checkAll(this)
    }

    override def isEmpty: Boolean = tail == Empty
  }

  val list = new Log(1, new Log("INFO_2", new Log("INFO_3", Empty)))
  println(list.all)
}
