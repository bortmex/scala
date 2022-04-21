package com.rog.teach.simple.stepik.exercises.week3fp
//Дан телефонный номер, числа в котором могут быть разделены -.
//Примером такого номера может служить 9-876-543-21-09. Номер может быть короче, а может быть длиннее.
//В программе номер хранится в переменной input, которая имеет тип String.
//
//Задача - посчитать, сколько раз каждое число встречается в номере. Из результата следует исключить -
object Solution8 extends App {
  def countNumbers(s: String): Map[Char, Int] = {
    var resultMap = Map('1' -> 0, '2' -> 0, '3' -> 0, '4' -> 0, '5' -> 0, '6' -> 0, '7' -> 0, '8' -> 0, '9' -> 0, '0' -> 0)
    s.toCharArray.filter(x => x != '-').foreach(x => resultMap += (x -> (resultMap(x) + 1)))
    resultMap
  }

  print(countNumbers("1234").toString())
}
