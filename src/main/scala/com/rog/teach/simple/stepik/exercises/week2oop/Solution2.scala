package com.rog.teach.simple.stepik.exercises.week2oop

//  от вас требуется написать лишь код классов. Создавать экземпляры классов и что-то принтить не надо
//  чтобы ваш код успешно прошел тесты - позаботьтесь, чтобы releaseYear был доступен даже вне тела класса
//
//  Instructor: id, name, surname
//
//  Методы класса:
//  - fullName: возвращает полное имя в виде Имя Фамилия.
//
//  первые буквы имени и фамилии обязательно должны быть заглавными, но на вход вполне могут передаваться данные, состоящие полностью как из больших букв, так и из маленьких.
//
//  Course: courseID, title, releaseYear, instructor
//
//  Методы класса:
//  - getID: возвращает id в формате courseID + instructor.id (например, если courseId = 1, а instructor.id = 2, то метод вернет 12)
//  - isTaughtBy(instructor): проверяет, является ли указанный человек инструктором курса
//  - copyCourse(newReleaseYear): возвращает новый экземпляр класса Course
object Solution2 extends App {

  class Instructor(val id: Int, name: String, surname: String) {
    def fullName: String = s"${this.name.capitalize} ${this.surname.capitalize}"
  }

  class Course(courseId: Int, title: String, val releaseYear: String, instructor: Instructor) {
    def getId: String = s"${this.courseId}${this.instructor.id}"
    def isTaughtBy(instructor: Instructor): Boolean = instructor.id == this.instructor.id
    def copyCourse(newReleaseYear: String):Course = new Course(this.courseId,this.title, newReleaseYear, this.instructor)
  }

  val instructor = new Instructor(1, "inst1", "xyi")
  val instructor1 = new Instructor(2, "inst2", "xyi")
  println(instructor.fullName)

  val course = new Course(1, "title", "releaseYear", instructor)
  println(course.getId)
  println(course.isTaughtBy(instructor))
  println(course.isTaughtBy(instructor1))
  println(course)
  println(course.copyCourse("newReleaseYear"))
}
