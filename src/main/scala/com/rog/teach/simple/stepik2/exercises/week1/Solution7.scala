package com.rog.teach.simple.stepik2.exercises.week1

//Известно, что
//aModifier является экземпляром класса Modifier
//newValue - новое значение переменной, передается при тестировании кода
//
//Исправьте код так, чтобы переменную можно было изменить вот таким образом:
//  aModifier.modifier = newValue
//  А получить значения переменной было возможно через:
//  aModifier.modifier
//class Modifier(val someVar: A) {
//  def get: A = someVar
//
//  def set(value): A = someVar = value
//}
object Solution7 extends App {
  class Modifier[A](var modifier: A) {
    def get: A = modifier

    def set_=(value: A) = modifier = value
  }
    var aModifier = new Modifier[String]("sdf")
    println(aModifier.modifier)
    aModifier.modifier = "sfg"
    println(aModifier.modifier)
}
