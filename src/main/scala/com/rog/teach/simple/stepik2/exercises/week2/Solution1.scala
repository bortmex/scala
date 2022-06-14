package com.rog.teach.simple.stepik2.exercises.week2

object Solution1 extends App {
  case class Course(id: Int, title: String)
//короче было implicit val titleOrdering: Ordering[Course] = Ordering.by(c => (c.title)) надо было чтобы и по айди тоже была сортировка
  implicit val titleOrdering: Ordering[Course] = Ordering.by(c => (c.id, c.title))

  val courses = List(
    Course(0, "Scala"),
    Course(1, "Functions"),
    Course(1, "Advanced Scala"),
    Course(4, "Spark"),
    Course(3, "Cats"),
    Course(3, "Akka")
  )

  println(courses.sorted)
}
