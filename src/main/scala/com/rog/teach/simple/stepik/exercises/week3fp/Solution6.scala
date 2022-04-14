package com.rog.teach.simple.stepik.exercises.week3fp

//Зачастую наряду с именем программы используется еще и версия программы, что позволяет отслеживать историю внесения изменений.
//
//Версия программы может задаваться в разных форматах, но мы поработаем со случаем, когда версия задается последовательностью чисел,
// указывающих на масштаб вносимых в программу изменений.
//
//Например, для указания предварительных и неофициальных версий обычно указываются числа меньше 1, такие как 0.9.
// Первой версии программы присваивается номер 1.0, версия с небольшими изменениями может иметь номер 1.11,
// и только когда создается программа с новой функциональностью — версия увеличивается на 1 и становится 2.0.
//
//Ваша задача - написать метод, позволяющий сравнивать версии между собой: def compare(v1: String, v2: String): Int. Метод возвращает:
//
//  -1 (если v1 < v2)

object Solution6 extends App {
  def compare(v1: String, v2: String): Int = {
    if(v1.nonEmpty || v2.nonEmpty) {
      val str1List = v1.split("\\.").toList
      val str2List = v2.split("\\.").toList
      var str11List = str1List.map(e => if (e.isEmpty || !e.matches("[0-9]+")) "0" else e)
      var str22List = str2List.map(e => if (e.isEmpty || !e.matches("[0-9]+")) "0" else e)

      if (str11List.size > str22List.size) str22List ++= List.fill(str11List.size - str22List.size) {"0"}
      str11List ++= List.fill(str22List.size - str11List.size) {"0"}

      val commonList = str11List.zip(str22List).filter(x => strToInt(x._1) != strToInt(x._2))
      if(commonList.isEmpty) return 0
      val firstStr = commonList.head._1
      val secondStr = commonList.head._2
      val first = strToInt(firstStr)
      val second = strToInt(secondStr)

      first.compareTo(second)
    } else {
      0
    }
  }

  def strToInt(str: String): Int = {
    import scala.util.Try
    import scala.util.Failure
    if(str.isEmpty) 0
    Try(str.toInt) match {
      case Failure(_: NumberFormatException) => 0
      case _ => str.toInt
    }
  }

  println(compare("2.01.1.1", "2.1.01.1"))
}
