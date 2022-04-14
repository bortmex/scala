package com.rog.teach.simple.stepik.exercises.week3fp

//Естественно, задача нацелена на отработку шаблонов, так что программа выдает один из следующих возможных результатов:
//
//  инициалы человека (заглавные буквы имени и фамилии с точкой, т.е. для John Smith результатом будет J. S. - внимание на точки и пробел)
//  сообщение Oops, something is wrong
object Solution4 extends App {

  object CustomerID {

    def apply(name: String) = s"${name}"

    def unapply(customerID: String): Option[String] = {
      val stringArray: Array[String] = customerID.split(" ")
      if (stringArray.tail.length == 1 && stringArray.head.substring(0, 1).matches("[a-zA-Z]") && stringArray.tail.head.substring(0, 1).matches("[a-zA-Z]")) {
        Some(stringArray.head.substring(0, 1).toUpperCase + ". " + stringArray.tail.head.substring(0, 1).toUpperCase + ".")
        //stringName1.split(" ").toList.flatMap(_.take(1)).mkString("", ". ", ".")
      } else {
        None
      }
    }
  }

  val str = scala.io.StdIn.readLine()
  val nameSurname = CustomerID(str)

  nameSurname match {
    case CustomerID(name) => println(name)
    case _ => println("Oops, something is wrong")
  }
}
