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

  trait Check {
    def compare(order: Order, orderB: Order): Boolean
  }

  object CustomerCheck extends Check {
    def compare(order: Order, orderB: Order): Boolean = {
      order.customer.id == orderB.customer.id
    }
  }

  object DateAndCustomerCheck extends Check {
    def compare(order: Order, orderB: Order): Boolean = {
      order.orderId == orderB.orderId && order.customer.id == orderB.customer.id && order.date == orderB.date
    }
  }

    println(CustomerCheck.compare(Order("1", "sdf", "sdf"), "1"))
    println(DateAndCustomerCheck.compare(order, newOrder))
}
