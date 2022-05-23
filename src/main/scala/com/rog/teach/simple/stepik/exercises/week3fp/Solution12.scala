package com.rog.teach.simple.stepik.exercises.week3fp

//
//На предыдущем шаге мы получали значения узлов на определенном уровне. Пришло время собрать значения всех узлов дерева в один общий список и написать метод collectNodes. Для этого нужно будет пройтись по всему дереву. Существует несколько способов обхода дерева:
//
//  по уровню (per level traversal) - в этом случае проходим по дереву уровень за уровнем
//  прямой (pre-order traversal), когда обход осуществляется в следующем порядке: корень, левый потомок, правый потомок
//  симметричный (in-order traversal), порядок обхода: левый потомок, корень, правый потомок
//  обратный (post-order traversal), порядок обхода: левый потомок, правый потомок, корень
object Solution12 extends App{

  abstract class BinaryTree[+T] {
    def value: T

    def leftChild: BinaryTree[T]

    def rightChild: BinaryTree[T]

    def isEmpty: Boolean

    def isLeaf: Boolean

    def collectNodes(): List[T]
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException

    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def isLeaf: Boolean = false

    def collectNodes(): List[Nothing] = List()
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

    override def collectNodes(): List[T] = {

      import scala.annotation.tailrec
      @tailrec
      def loop(queue1: List[BinaryTree[T]] = List[BinaryTree[T]](this),
               queue2: List[BinaryTree[T]] = List[BinaryTree[T]](),
               list: List[T] = List()): List[T] = {

        var queue2Result = List[BinaryTree[T]]()
        if (queue1.nonEmpty && !queue1.head.rightChild.isEmpty) {
          queue2Result = queue2Result :+ queue1.head.rightChild
        }

        if (queue1.nonEmpty && !queue1.head.leftChild.isEmpty) {
          queue2Result = queue2Result :+ queue1.head.leftChild
        }

        if (queue1.nonEmpty) {
          loop(queue1.tail, queue2Result ::: queue2, list :+ queue1.head.value)
        } else if (queue2.nonEmpty) {
          loop(queue2, queue1, list)
        } else {
          list
        }
      }
      loop()
    }

  }
  println(tree.collectNodes().sortBy(_.toString))
  println()
}
