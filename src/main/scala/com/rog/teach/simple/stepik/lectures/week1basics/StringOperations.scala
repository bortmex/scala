package com.rog.teach.simple.stepik.lectures.week1basics

object StringOperations extends App{

  val aString: String = "Hello, world!"
  println(aString.length) // выводит 13
  println(aString.charAt(1)) // выводит e
  println(aString.substring(0, 2)) // выводит He
  println(aString.split(" ").toList) // выводит List(Hello,, world!)
  println(aString.startsWith("He")) // выводит true
  println(aString.replace("!", ".")) // выводит Hello, world.
  println(aString.toLowerCase) // выводит hello, world!
  println(aString.toUpperCase) // выводит HELLO, WORLD!
  println("abcd".reverse) // выводит dcba
  println("abcd".take(2)) // выводит ab
  println("//---------------------------------------------------------------------------")
  val List1 =  List(2, 3) :+ 1
  println(List1)
  println("//---------------------------------------------------------------------------")
  println('1' +: "42" :+ '3') // выводит 1423
  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++: "bc" :++ "d") // abcd
  println("//---------------------------------------------------------------------------")
  println(1 +: List(2, 3)) // List(1, 2, 3)
  println(List(2, 3):+ 1) // List(1, 2, 3)
  println(List(1, 2) ++ List(3, 4)) // List(1, 2, 3, 4)
  println(List(1, 2) +: List(3, 4)) //List(List(1, 2), 3, 4)
  println("//---------------------------------------------------------------------------")
  var name = "John"
  println(s"Hello $name")

  name = "John"
  val surname = "Smith"
  println(s"Hello \t ${name + " " + surname}")

  val someString = "\tThis is \n a string"
  println(raw"The link is \t 546")
  println(raw" This is \n a $surname string")
  println(surname:++name)
  //println(raw" \t $someString")
  //println(someString)
}
