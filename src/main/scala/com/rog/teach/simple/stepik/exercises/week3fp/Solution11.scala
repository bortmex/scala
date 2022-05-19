package com.rog.teach.simple.stepik.exercises.week3fp


//Узел считается листом, если у него нет ни правого, ни левого потомка. Так что дерево, представленное на рисунке, имеет четыре листа со значениями 4, 8, 6, 7
//Примечание:
//  не забудьте дописать метод isLeaf
//  чтобы не перегружать рабочее пространство, код BinaryTree и TreeEnd был скрыт (он такой же, как код, представленный выше). Простой учитывайте, что этот код есть и работать вам надо только с Node
//  принт результатов на вас (учитывайте,  что в коде прописан object Main extends App и вы можете сразу начинать писать print)
//  вам доступна переменная tree, хранящая дерево, для которого потребуется вызвать метод collectLeaves
//  полученные значения листьев должны быть отсортированы по возрастанию
//  как видно из определения функции, в результате вы получите List[BinaryTree[T]], т.е. для дерева, представленного в качестве примера, результат будет List(Node(7,TreeEnd,TreeEnd), Node(6,TreeEnd,TreeEnd), Node(8,TreeEnd,TreeEnd), Node(4,TreeEnd,TreeEnd)). Вам же надо вывести List(4, 6, 7, 8)
//  постарайтесь реализовать хвостовую рекурсию для метода collectLeaves
object Solution11 extends App {

  abstract class BinaryTree[+T] {
    def value: T

    def leftChild: BinaryTree[T]

    def rightChild: BinaryTree[T]

    def isEmpty: Boolean

    def isLeaf: Boolean

    def collectLeaves: List[BinaryTree[T]]

    def countLeaves: Int

    def nodesAtLevel(level: Int): List[BinaryTree[T]]
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException

    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def isLeaf: Boolean = false

    override def collectLeaves: List[BinaryTree[Nothing]] = List()

    override def countLeaves: Int = 0

    override def nodesAtLevel(level: Int): List[BinaryTree[Nothing]] = {
      List()
    }
  }

  val tree = Node(1,
    Node(2,
      Node(4, TreeEnd, TreeEnd),
      Node(5,
        TreeEnd, Node(8, TreeEnd, TreeEnd))),
    Node(3, Node(6, TreeEnd, TreeEnd),
      Node(7, TreeEnd, TreeEnd)))

  case class Node[+T](
                       override val value: T,
                       override val leftChild: BinaryTree[T],
                       override val rightChild: BinaryTree[T])
    extends BinaryTree[T] {
    override def isEmpty: Boolean = false

    override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty

    override def countLeaves: Int = collectLeaves.size

    override def collectLeaves: List[BinaryTree[T]] = {
      import scala.annotation.tailrec
      @tailrec
      def loop(toInspect: List[BinaryTree[T]] = List(this), leaves: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = {

        if (toInspect.isEmpty) {
          return leaves
        }
        var result = List[BinaryTree[T]]()
        if (!toInspect.head.rightChild.isEmpty) {
          result = result :+ toInspect.head.rightChild
        }
        if (!toInspect.head.leftChild.isEmpty) {
          result = result :+ toInspect.head.leftChild
        }

        var result1 = leaves
        if (toInspect.head.isLeaf) {
          result1 :+= toInspect.head
        }
        loop(result ::: toInspect.tail, result1)
      }

      loop()
    }

    override def nodesAtLevel(level: Int): List[BinaryTree[T]] = {

      import scala.annotation.tailrec
      @tailrec
      def loop(queue1: List[BinaryTree[T]] = List[BinaryTree[T]](this),
               queue2: List[BinaryTree[T]] = List[BinaryTree[T]](),
               list: List[BinaryTree[T]] = List(),
               levelLocal: Int = 0): List[BinaryTree[T]] = {

        var queue2Result = List[BinaryTree[T]]()
        if (queue1.nonEmpty && !queue1.head.rightChild.isEmpty) {
          queue2Result = queue2Result :+ queue1.head.rightChild
        }

        if (queue1.nonEmpty && !queue1.head.leftChild.isEmpty) {
          queue2Result = queue2Result :+ queue1.head.leftChild
        }

        if (queue1.nonEmpty) {
          loop(queue1.tail, queue2Result ::: queue2, list :+ queue1.head, levelLocal)
        } else if (queue2.nonEmpty && level != levelLocal) {
          loop(queue2, queue1, List(), levelLocal + 1)
        } else if (level == levelLocal) {
          list
        } else {
          List()
        }
      }
      loop()
    }

  }

  println(tree.nodesAtLevel(4))
  println()
}