package com.rog.teach.simple.stepik2.exercises.week1
//Проверка расстановки скобок в строке
//Напишите функцию isBalanced(aString): Boolean, которая проверяет расстановку круглых скобок в строке: в строке не должно
//  быть лишних скобок (т.е. количество открывающих скобок должно совпадать с закрывающими).
//  Например: для строки d(e@5)s функция вернет true, а вот для строки (d)( выдаст false
//
//  Примечание:
//  кроме скобок в строке могут встречаться любые другие символы
//  не забываем оптимизировать код и использовать значение по умолчанию
//  напишите только код функции, принт результатов от вас не требуется
object Solution3 extends App {
  def isBalanced(aString: String): Boolean = {
      aString.foldLeft(0)((sum, element) => {
        val asd = if (element == '(') 1
        else if (element == ')') -1
        else 0
        sum + asd
      }) == 0
  }

  println(isBalanced("sdfdsf(dfgdf)dfg(dfg("))
}
