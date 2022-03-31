package com.rog.teach.simple.stepik.exercises.week2oop

object Solution4 extends App {
  abstract class Event {
    def trigger(eventName: String): Unit
  }

  class Listener(val eventName: String, var event: Event) {
    def register(evt: Event) { event = evt }
    def sendNotification() { event.trigger(eventName) }
  }

  val notification: Listener = new Listener("mousedown", null)

  notification.register((eventName: String) => {
    println(s"trigger ${eventName} event")
  })
}
