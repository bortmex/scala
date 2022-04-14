package com.rog.teach.simple.stepik.exercises.week3fp


//Напоследок - давайте создадим простенького чат-бота. Бот реагирует только на три фразы:
//
//  hello
//  bye
//  what's up
//  Соответственно, его ответами будут :
//
//  Hi, I'm Bot
//  Bye-bye
//  sup-sup
//
//
//  Примечание:
//
//  ваша задача - использовать PartialFunction
//  и неплохо бы было предусмотреть, чтобы никаких MatchError не возникало (решение, где вручную указывается значение по умолчанию - не подойдет)
//  позаботьтесь, чтобы обратиться к функции можно было через переменную типа String => Option[String] с именем chatbot - иначе ваш код не пройдет тесты
//  можете сразу браться за написание требуемого кода, object Main уже присутствует в системе
//  никаких принтов вам прописывать не надо
//  подумайте, как решить задачу не через isDefinedAt()
object Solution5 extends App{
  def chatbot(str:String): Option[String] = {

    val aPartialFunction: PartialFunction[String, String] = {
      case "hello" => "Hi, I'm Bot"
      case "bye" => "Bye-bye"
      case "what's up" => "sup-sup"
    }
    val lift = aPartialFunction.lift
    lift(str)
  }


//  val chatbot = ({
//    case "hello"     => "Hi, I'm Bot"
//    case "bye"       => "Bye-bye"
//    case "what's up" => "sup-sup"
//  }: PartialFunction[String, String]).lift

}
