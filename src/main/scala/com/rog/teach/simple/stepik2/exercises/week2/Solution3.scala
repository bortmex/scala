package com.rog.teach.simple.stepik2.exercises.week2
//Заставьте код работать, если известно, что
//в коде определен case-класс Price:
//  case class Price(price: Int)
//  в объекте Price задается имплиситный класс PriceOps, который вам доступен для модификации
//  конечный результат при тестировании выводится через println(Price(price) - discount) - это прописано за вас
object Solution3 extends App {
  case class Price(price: Int){
  }

  implicit class PriceOps(p: Price) {
    def -(n: Int): Int = p.price - n
  }

  println(Price(500) - 50)
}
