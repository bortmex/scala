package com.rog.teach.simple.stepik2.exercises.week2
//Реализуйте magnet pattern для следующего кода:
//  trait Discount {
//    def discount(coupon: String) = "coupon applied"
//    def discount(percentage: Int) = s"$percentage % discount"
//  }
object Solution6 extends App {
  trait Discount {
    def discount(coupon: String) = "coupon applied"

    def discount(percentage: Int) = s"$percentage % discount"
  }

  trait MathMagnet {
    def apply(): String
  }

  def discount(magnet: MathMagnet): String = magnet()

  implicit class IncrementInt(x: Int) extends MathMagnet {
    override def apply(): String = s"$x % discount"
  }

  implicit class IncrementStr(x: String) extends MathMagnet {
    override def apply(): String = {
      if (x.forall(Character.isDigit))
        IncrementInt(x.toInt).apply()
      else
        "coupon applied"
    }
  }

  println(discount(1))
  println(discount("12"))
}
