package com.rog.teach.simple.stepik2.exercises.week2
//Поработаем с заказами. Задано два класса:
//  case class Customer(id: String, name: String)
//  case class Order(orderId: String, customer: Customer, date: String)
//  Ваша задача - создать класс типа:
//  должна быть предусмотрена возможность сравнивать заказы 1) по id клиента (CustomerCheck) и 2) одновременно по id клиента и дате заказа (DateAndCustomerCheck)
//  должен быть доступен метод compare(orderA, orderB): Boolean
object Solution4 extends App {

  case class Customer(id: String, name: String)

  case class Order(orderId: String, customer: Customer, date: String)
//TODO ушел за хлебом

//  trait InfoProvider[T] {
//    def info(value: T): String
//  }
}
