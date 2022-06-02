package com.rog.teach.simple.stepik2.exercises.week1
//Часть 1:
//  Напишите функцию countChars(someString): Map[Char, Int] , которая позволит посчитать, сколько раз каждый из символов
//  был встречен в заданной строке. Результат функции требуется возвращать в виде Map(символ -> сколько раз встретился)
//  Например, результатом выполнения countChars("None")  должно быть Map(n -> 2, o -> 1, e -> 1)
//
//  Часть 2:
//  Так как мы хотим потренироваться в использовании коллекций, то конечный результат, отправляемый на проверку, просим
//  конвертировать в список и отсортировать по возрастанию количества встреченных символов.
//  Например, для строки "Sst" финальным результатом будет List((t,1), (s,2))
object Solution2 extends App{

  var inputString = "quQQry"

  def countChars(someString: String): Map[Char, Int] = {
    someString.foldLeft(Map[Char, Int]()){ (m, c) => m + (c.toLower -> (m.getOrElse(c.toLower, 0) + 1))}
  }

  println(countChars(inputString).toSeq.sortBy(_._2).toList)
}
