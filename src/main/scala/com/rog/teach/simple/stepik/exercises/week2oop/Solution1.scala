package com.rog.teach.simple.stepik.exercises.week2oop

object Solution1 extends App {
  class Employee(val name: String, var salary: Double) {
    // здесь пропущена строка кода
    def this() = this("John", 0)
  }

  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")
}
