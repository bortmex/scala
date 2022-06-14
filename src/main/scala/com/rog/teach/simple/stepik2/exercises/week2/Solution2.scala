package com.rog.teach.simple.stepik2.exercises.week2

//в программе за вас определен case-класс Person со следующим кодом:
//  case class Person(age: Int) {
//    def increaseAge: Unit = println(age + 1)
//  }
//  для тестирования передается значение возраста и записывается это значение в переменную age, тип этой переменной String
//  финальный вызов результата (это также заранее прописано за вас) происходит через age.increaseAge
object Solution2 extends App {
  case class Person(age: Int) {
    def increaseAge: Unit = println(age + 1)
  }

  object Person {
    implicit def str2Person(param: String): Person = Person(param.toInt)
  }

  import Person.str2Person
  val age = "1234"
  age.increaseAge
}
