package com.rog.teach.simple.stepik.exercises.week2oop

object Solution5 {
//  Перед вами код, доставшийся вам от коллеги, успевшего поработать над задачей до вашего прихода. Ознакомившись с кодом, вы обнаруживаете, что чего-то в коде не хватает. Видимо, часть изменений, внесенных в код, не сохранилась.
//
//  Ваша задача - исправить имеющиеся в коде недочеты:
//
//  правильно организовать наследование
//  дописать пропущенные ключевые слова (например, class, trait)

  object Configs {
    val ACCOUNT_TYPE_DEFAULT = "free"
    val ACCOUNT_TYPE_PAID = "paid"
    val SUBSCRIPTION_STATUS = "active"
  }

  object Settings {
    case class AccountSettings(
                                email: String,
                                password: String,
                                picture: String)

    case class SubscriptionSettings(
                                     payment: String,
                                     notifications: String,
                                     expiration: String)
  }

  trait Subscriber {
    def subscribe(settings: Settings.SubscriptionSettings): Unit = println("subscribed")
  }

  trait Unsubscriber {
    def unsubscribe(): Unit = println("unsubscribed")
  }

  abstract class Account(accountID: String, settings: Settings.AccountSettings) {
    def info(): Unit
  }

  class FreeAccount(
    accountID: String,
    settings: Settings.AccountSettings) extends Account(accountID, settings) with Subscriber {

    override def info(): Unit = println(s"Account Type: ${Configs.ACCOUNT_TYPE_DEFAULT}")
  }

  class PaidAccount(
    accountID: String,
    settings: Settings.AccountSettings) extends Account(accountID, settings) with Unsubscriber {

    override def info(): Unit = {
      println(s"Account Type: ${Configs.ACCOUNT_TYPE_PAID}")
      println(s"Subscription Status: ${Configs.SUBSCRIPTION_STATUS}")
    }
  }
}
