package com.rog.teach.simple.stepik2.exercises.week1
//Потренируемся в работе с монадами на примере списков и опций.
//
//Переменная users хранит профили пользователей (в нашем случае их всего два).
//Для каждого пользователя User задается имя(name) и его лучший друг (bf). Причем, лучшего друга у пользователя может и не быть.
//Service предоставляет нам возможность найти пользователя (findUser) по имени (искомого пользователя, кстати, может и не оказаться).
//Программа позволяет получить имя лучшего друга у лучшего друга пользователя, найденного по заданному имени. Это достигается за счет последовательного применения двух flatMap.
//На данный момент программа выдает NullPointerException, натыкаясь на отсутствующего лучшего друга у пользователя - это надо исправить:
//  если лучшего друга  нет - должно выводиться уведомление No bf, иначе же мы должны получать имя пользователя (так что не забудьте при выводе конечного результата избавиться от Some, для этого можно воспользоваться getOrElse).
//  если пользователь в списке users отсутствует, должно выводиться сообщение No user (возможно, будет полезно вспомнить шаблоны)
//
//  Примечание:
//
//  переменная nameToFind хранит в себе имя, передаваемое программе для тестирования
//  по большей части мы не стали скрывать от вас код, дав возможность поработать с более-менее полным кодом. Просто учтите,
//  что для прохождения тестирования список users должен гарантировано содержать два профиля: Mike: Sam, Bob, Alice и John:
//  Joe - указанные имена обязательно должны присутствовать в изначально заданном порядке, а в остальном можете вносить любые требуемые изменения
//  чтобы обойтись без рекурсии, договоримся, что findUser ищет пользователя только в голове списка, не заходя в хвост
//  (т.е. в users будет проходиться только по Mike и John, а значит, пользователя с именем Sam уже находить не будет)
//  не ограничивайтесь одним лишь filter при поиске, возможно, вместо него вам подойдут другие методы, например,
//  существует еще .find
object Solution10 extends App{
  // исправьте код
  case class User(name: String, bf: User)

  val users = List(
    User("Mike", User("Sam", User("Bob", User("Alice", null)))),
    User("John", User("Joe", null)),
  )

  object Service {
    def findUser(users: List[User], name: String): Option[User] = users.find(_.name == name)
  }

  def getBf(user: User): Option[User] = {
    if(matchUser(user)) {
      Option(user.bf)
    } else {
      Option.empty
    }
  }

  def matchUser[T](user: T): Boolean = {
    user match {
      case User(name, bf) => true
      case _ => false
    }
  }

  val user: Option[User] = Service.findUser(users, "Mike1")
  val bf = user.flatMap(getBf).flatMap(getBf)

  println(if(user.isEmpty) "No user" else if(bf.isEmpty) "No bf" else bf.map(_.name).head)
}