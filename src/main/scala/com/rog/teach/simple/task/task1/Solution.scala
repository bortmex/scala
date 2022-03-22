package com.rog.teach.simple.task.task1

object Solution {

  /**
   * This method computes the sum of all elements in the list xs. There are
   * multiple techniques that can be used for implementing this method, and
   * you will learn during the class.
   *
   * For this example assignment you can use the following methods in class
   * `List`:
   *
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list
   *    is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
   *    list `xs` without its `head` element
   *
   * ''Hint:'' instead of writing a `for` or `while` loop, think of a recursive
   * solution.
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int = if (xs.isEmpty) 0 else xs.head + sum(xs.tail)

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  //my Solution
  def max(xs: List[Int]): Int = {
    if (xs.size == 1 || xs.isEmpty)
      throw new NoSuchElementException
    if (xs.size == 2)
      if (xs.head > xs.last)
        xs.head
      else
        xs.last
    else if (xs.head > max(xs.tail))
      xs.head
    else max(xs.tail)
  }

  //as it should have been
  def maxAnswer(xs: List[Int]): Int = if (xs.isEmpty) throw new NoSuchElementException()
  else if (xs.tail.isEmpty) xs.head
  else math.max(xs.head, max(xs.tail))
}

object Main extends App{
  println(Solution.max(List(1,3,2)))
  println(Solution.sum(List(1,3,2)))
}