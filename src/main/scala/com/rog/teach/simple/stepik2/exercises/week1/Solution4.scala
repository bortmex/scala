package com.rog.teach.simple.stepik2.exercises.week1
//Реализуйте метод formatter, принимающий на вход два параметра:
//  формат числа (должен иметь тип String), тогда, например, в качестве формата можно будет указать "%2.3f"
//  число, которое необходимо отформатировать (тип Double)
//  В качестве результата метод должен возвращать отформатированное число типа String.
//  Далее воспользуйтесь написанной функцией formatter и задайте формат val simpleFormat, округляющий числа до двух
//  знаков после запятой. При реализации этого шага вам стоит вспомнить про Eta-расширение. И учесть, что если в
//  программе при тестировании задать список чисел numbers, то округление каждого числа из списка должно быть возможно
//  через:
//  numbers.map(simpleFormat)
//  Соответственно, если в коде вместо simpleFormat задать preciseFormat, то должен сработать такой вызов:
//  numbers.map(preciseFormat)
//
//  Примечание:
//  имплементация preciseFormat от вас не требуется, он дан в качестве примера, чтобы лишний раз напомнить о
//  возможностях и преимуществах eta-расширения
//  напишите только код для simpleFormat и formatter, никаких принтов от вас не требуется
//  список numbers формируется в системе при тестировании, вам его создавать не надо
object Solution4 extends App {

  def formatter(s1: String)(d1: Double) = s1.format(d1)

  val simpleFormat = formatter("%2.2f") _

  println(List(1.231,234.5434543).map(simpleFormat))

}
