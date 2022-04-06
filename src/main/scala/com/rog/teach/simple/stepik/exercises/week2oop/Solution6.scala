package com.rog.teach.simple.stepik.exercises.week2oop

//Напишите функцию для класса Person, которая будет срабатывать на вызов:
//
//  val person = new Person("Bob")
//  println((+person).name)
//  и выводить на экран Bob NoSurname
object Solution6 extends App {

  class Person(var name: String) {
    def unary_+ : Person = new Person(s"$name NoSurname")
  }

  val person = new Person("Bob")
  println((+person).name)
}
