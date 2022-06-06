package com.rog.teach.simple.stepik2.exercises.week1

object Solution6 extends App {
  abstract class Customer {
    def isVegetarian: Boolean
  }


  class Order[T<:Customer](val person: T) {
    def showMenu: String = if (person.isVegetarian) "vegetarian menu" else "ordinary menu"
  }
//Bad ->
//  class Order1[T>:Customer](val person: T) {
//    def showMenu: String = if (person.isVegetarian) "vegetarian menu" else "ordinary menu"
//  }

  trait Fruit

  class Apple extends Fruit

  class Banana extends Fruit

//  //  инвариантность
//  class FruitBasket[T]
//  val invariantBasket: FruitBasket[Fruit] = new FruitBasket[Fruit]
//
//  //ковариантность (тут мы признали, что яблоки тоже фрукты):
//  class FruitBasket[+T]
//  val covBasket: FruitBasket[Fruit] = new FruitBasket[Apple]
//
//  //контравариантность
//  class FruitBasket[-T]
//  val contrBasket: FruitBasket[Apple] = new FruitBasket[Fruit]


  abstract class Animal(val tongue: String) {
    val age: Int
    def isAlive: Boolean
  }

  case class Dog(age: Int) extends Animal("bark") {
    def isAlive = age < 13
  }

  case class Cat(age: Int, diet: String) extends Animal("meow") {
    def isAlive = age < 15
  }


  //ковариантность
  case class Named[+T](name: String, get: T)
  def speak(na: Named[Animal]): Unit = {
    val animal = na.get
    if (animal.isAlive)
      println(s"${na.name}: ${animal.tongue}")
  }
  speak(Named[Cat]("2134", Cat(10,"cat")))


  //контравариантность
  class Vet[-A]
  def treatDogs(vet: Vet[Dog]) {}
  val commonVet = new Vet[Animal]()
  treatDogs(commonVet)



  class Programmer(name: String)
  case class DataAnalyst(val name: String) extends Programmer(name)

  //Получим ошибку, так как ковариантное поле класса использовано совместно с контравариантным типом
//  class Employee[-T](val employee: T) {
//    def info() = println(employee)
//  }
//  val employee: Employee[DataAnalyst] = new Employee[Programmer](new Programmer("Bob"))
//  employee.info()


  //Для инвариантного типа использован класс, больше подходящий для ситуации с контравариантным типом
//  class Employee[T](val employee: T) {
//    def info() = println(employee)
//  }
//  val employee: Employee[DataAnalyst] = new Employee[Programmer](new Programmer("Bob"))
//  employee.info()

  //Несоответствие типов
//  class Employee[+T](val employee: T) {
//    def info() = println(employee)
//  }
//  val employee: Employee[DataAnalyst] = new Employee[Programmer](DataAnalyst("Bob"))
//  employee.info()


  //DataAnalyst(Bob)
  class Employee[+T](val employee: T) {
    def info() = println(employee)
  }
  val employee: Employee[DataAnalyst] = new Employee[DataAnalyst](DataAnalyst("Bob"))
  employee.info()
}
