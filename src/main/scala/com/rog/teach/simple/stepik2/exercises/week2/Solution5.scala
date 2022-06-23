package com.rog.teach.simple.stepik2.exercises.week2

object Solution5 extends App {
  case class Greeting(text: String) {
    def name: String = ""

    def occupation: String = ""

    def level: String = "middle"
  }

  implicit class ImplicitGreeting2(text: String) extends Greeting(text) {
    def isMiddle: Boolean = level == "middle"
    def apply(implicit greeting: Greeting) = greeting
  }

  val greeting = "My name is [ X ] and I'm a [ Y ]. And I have [ middle ] years of experience."
//TODO доделать
  println(greeting.name)
  println(greeting.occupation)
  println(greeting.level.isMiddle)
}
