package com.rog.teach.simple.stepik.exercises.week2oop

//Пора собрать код. Продублируем еще раз условие:
//
//  last - возвращает последнее поступившее сообщение (иначе говоря - head списка)
//  previous - возвращает все ранее поступившие собщения(это будет tail или хвост списка), за исключением самого последнего (т.е. за исключением head)
//  isEmpty - проверяет, если ли в нашем списке сообщения
//  all - предоставляет нам содержимое нашего списка в виде строки
//  add(msg) - добавляет сообщение в список
//
//
//  Примечание:
//
//  создавать экземпляр класса не требуется, напишите только код для LogList, Log, Empty
//  Empty не содержит в себе элементов, поэтому для previous и last бросает исключение NoSuchElementException
//  all, описанный в Empty возвращает пустую строку, а all, описанный в Log, требует написания рекурсивной функции, результатом которой будет строка, содержащая все поступившие в систему сообщения (сообщения разделены пробелом, но начинаться с пробела итоговая строка не должна)
//  например, даны сообщения new Log(“m1”, new Log(“m2”, new Log(“m3”, Empty))), тогда результатом работы метода all должна быть строка  m1 m2 m3
object Solution8 extends App {
  abstract class LogList {
    def add(msg: String): LogList

    def previous: LogList

    def last: String

    def all: String

    def isEmpty: Boolean
  }

  object Empty extends LogList {
    override def add(msg: String): LogList = new Log(msg, Empty)

    override def previous: LogList = throw new NoSuchElementException

    override def last: String = throw new NoSuchElementException

    override def all: String = ""

    override def isEmpty: Boolean = true
  }

  class Log(head: String, tail: LogList) extends LogList {
    override def add(msg: String): LogList = new Log(msg, this)

    override def previous: LogList = tail

    override def last: String = head

    override def all: String = {
      def checkAll(list: LogList): String = {
        if (list.isEmpty) list.last else s"${list.last} ${checkAll(list.previous)}"
      }

      checkAll(this)
    }

    override def isEmpty: Boolean = tail == Empty
  }

  val list = new Log("INFO_1", new Log("INFO_2", new Log("INFO_3", Empty)))
  println(list.all)
}
