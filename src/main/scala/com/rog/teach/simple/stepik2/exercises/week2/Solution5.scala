package com.rog.teach.simple.stepik2.exercises.week2
//В системе определен шаблон приветственного сообщения. И хранится он в переменной greeting:
//  val greeting = "My name is [ X ] and I'm a [ Y ]. And I have [ Z ] years of experience."
//  Также в наличии case-класс case class Greeting(text: String), в котором определены методы для вычленения из текстового шаблона такой информации, как:
//  имя def name: String
//  профессия def occupation: String
//  уровень def level: String - возвращает junior, middle, senior в зависимости от указанного опыта
//  На данный момент получить желаемую информацию можно посредством вот такого вызова:
//  Greeting(greeting ).occupation
//  А надо, чтобы работало вот так:
//  greeting.occupation
//  Кроме того, требуется проверка уровня посредством метода isMiddle, возвращающего true либо false в зависимости от того, middle человек или нет. И результат проверки должен быть доступен через:
//  greeting.level.isMiddle
//  Напишите ваше решение поставленных задач.
  object Solution5 extends App {
  case class Greeting(text: String) {
    def name: String = ""

    def occupation: String = ""

    def level: String = "middle"
  }

  implicit class ImplicitGreeting2(text: String) extends Greeting(text) {
    def isMiddle: Boolean = text == "middle"
    def apply(implicit greeting: Greeting) = greeting
  }

  val greeting = "My name is [ X ] and I'm a [ Y ]. And I have [ middle ] years of experience."

  println(greeting.name)
  println(greeting.occupation)
  println(greeting.level.isMiddle)
}
