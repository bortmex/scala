package com.rog.teach.simple.stepik2.exercises.week1

object Solution5 extends App {
  def add(x: Int, y: => Int) = x + y
  def multiply(f: () => Int) = f() * 2
  def four: Int = 4
  def two(): Int = 2

  add(1, four)
  multiply(two)
  //Bad ->
  //add(1, two _)
  add(1, 2)
  multiply(two _)
  add(1, (() => 2)())
  //Bad ->
  //multiply(four)
  multiply(() => 4)
  //Bad ->
  //multiply(12)
  add(two(), four)
  //Bad ->
  //add(1, () => 2 )
}
