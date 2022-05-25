package com.rog.teach.simple.stepik2.exercises.week1

//Ваша задача - написать функцию duplicate(someList, nDups), которая создает указанное количество nDups дубликатов каждого элемента списка someList.
//
//Например, если был передан список List(1, 2, 3), а nDups = 2, то результатом будет List(1, 1, 2, 2, 3, 3)
object Solution1 extends App {
    def duplicate[T](someList: List[T], nDups: Int): List[T] = {
      someList.flatMap(List.fill(nDups)(_))
    }
    println(duplicate(List(1,2), 3))

  def `short name`(name: String) = name.take(2).toUpperCase + "."

  val names = List("Alex", "Sam", "Peter", "andrew")

  names map `short name` filter(_.startsWith("A")) foreach println
}
