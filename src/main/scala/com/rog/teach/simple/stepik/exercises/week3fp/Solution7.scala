package com.rog.teach.simple.stepik.exercises.week3fp
//Давайте напишем финальный код. Продублируем условие задания еще раз.
//Имеем API, которое:
//
//  содержит поле config вида Map[String, String], хранящее в себе два ключа: ip адрес хоста (host) и порт (port)
//  у вас нет гарантии, что у ключа есть значение, могло ведь случиться, что в конфигурационном файле, откуда значения хоста и порта должны были считаться, эти значения отсутствовали
//  в наличии класс Connection с методом connect, устанавливающим соединение с сервером. В случае установки соединения возвращается статус "Connected". Не факт, что соединение будет установлено.
//  у класса есть объект-компаньон с методом apply , который возвращает Option[Connection]. Именно этот метод отвечает за отправку запроса на создание нового соединения.
//  Ваша задача: установить соединение с сервером (напишите только код для установки соединения с сервером и вывода статуса соединения на экран, импортировать ничего не надо, как не надо прописывать object Main extends App и подобное).
//
//  API реализовывать не надо, описанный функционал уже доступен, вам остается только грамотно воспользоваться предоставленными методами для решения поставленной задачи.
//  Примечание к методу connect:
//
//  в случае успешного соединения на экране должна появиться надпись Connected (не забудьте предусмотреть вывод)
//  если же соединение не установлено - на экране вообще ничего не появляется
object Solution7 extends App {
  val config: Map[String, String] = Map(("port", "8080"), ("host", "localhost"))

  object Connection {
    var port = "port"
    var host = "host"
    def connect: Option[String] = {
      if ( port != null && host != null) Option("Connected") else Option("")
    }

    def apply(port: String, host: String): Option[Connection.type] = {
      this.port = port
      this.host = host
      Option.apply(this)
    }
  }

  config.get("host").flatMap(host => config.get("port").flatMap(port => Connection(host, port)).map(connection => connection.connect)).foreach(println)
}
