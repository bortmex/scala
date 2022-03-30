package com.rog.teach.simple.stepik.exercises.week2oop
//Ваша задача - реализовать два класса: Button и RoundedButton.
//
//  Для класса Button
//
//  предусмотрите возможность указания label типа String при создании экземпляра класса
//  пропишите метод def click(): String, возвращающий строку, в которой указан label, заданный при создании кнопки:  button -label- has been clicked
//
//
//  Для RoundedButton
//
//  предусмотрите наледование от Button
//  реализуйте метод click, который похож на родительский метод click, но в отличие от него содержит слово rounded перед button: rounded button -label- has been clicked
object Solution3 extends App {
  class Button(label:String) {
    def this() = this("test")
    def click(): String = s"button -${label}- has been clicked"
  }

  class RoundedButton(label: String) extends Button(label) {
    override def click(): String = s"rounded ${super.click()}"
  }

  val roun = new RoundedButton("label1")
  println(roun.click())
}
