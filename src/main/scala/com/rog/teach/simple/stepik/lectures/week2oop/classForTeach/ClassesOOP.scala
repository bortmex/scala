package com.rog.teach.simple.stepik.lectures.week2oop.classForTeach

object ClassesOOP extends App{

  class Student(id: Int, val name: String){
    val uni = "University"
    println("qwe")
  }

  val student = new Student(0, "Bob")
  println(student.name)//<--without val dont work

}
