package com.rog.teach.simple.teams.monads
//https://www.youtube.com/watch?v=X6UdSS5bjV4
//простой пример монады
object Solution1 extends App {
  sealed trait Expr
  case class Val(x: Int) extends Expr
  case class Div(a: Expr, b: Expr) extends Expr

  1
  6 / 2
  6 / (3 / 1)
  Val(1)
  Div(Val(6), Val(2))
  Div(Val(6), Div(Val(3), Val(1)))

  def eval(expr: Expr): Int =
    expr match {
      case Val(x) => x
      case Div(a, b) => eval(a) / eval(b)
    }
}
