package com.rog.teach.simple.stepik.exercises.week3fp

//Немного разомнемся перед следующим заданием. Напишем метод def hasPath(tree: BinaryTree[Int], target: Int): Boolean,
// который возвращает true, если в заданном дереве tree существует такой путь от корня до листа, что сумма значений узлов,
// лежащих на этом пути, равняется заданному значению target.
//Для дерева, представленного на изображении, hasPath вернет true при target равном 7 и вернет false при target равном 3.
//
//Примечание:
//
//  в системе заранее прописан класс BinaryTree, Node, TreeEnd - их структура должна быть вам знакома с предыдущих шагов.
//  Соответственно, вам доступны следующие методы: value, leftChild, rightChild, isEmpty, isLeaf
//  принтить результаты не надо, напишите только код метода hasPath
//  решение можно реализовать как в виде обычной рекурсии, так и в виде хвостовой. Мы не будем ограничивать вас в выборе,
//  только посоветуем все же постараться реализовать хвостовую рекурсию
  object Solution13 extends App{

  abstract class BinaryTree[+T] {
    def value: T

    def leftChild: BinaryTree[T]

    def rightChild: BinaryTree[T]

    def isEmpty: Boolean

    def isLeaf: Boolean

    def hasPath(tree: BinaryTree[Int], target: Int): Boolean
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException

    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def isLeaf: Boolean = false

    override def hasPath(tree: BinaryTree[Int], target: Int): Boolean = false
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

    def hasPath(tree: BinaryTree[Int], target: Int): Boolean = {
    var listresult = false
      import scala.annotation.tailrec
     //@tailrec
      if(tree.isEmpty){
        return listresult
      }

      def loop(queue: List[BinaryTree[Int]] = List[BinaryTree[Int]](tree),
               sum: Int = tree.value): Unit = {

        if (!queue.head.leftChild.isEmpty) {
          loop(queue.head.leftChild +: queue.tail, sum + queue.head.leftChild.value)
        }
        if (!queue.head.rightChild.isEmpty) {
          loop(queue.head.rightChild +: queue.tail, sum + queue.head.rightChild.value)
        }
        if(queue.head.isLeaf) {
          listresult ||= (sum == target)
        }
      }
      loop()
      listresult
    }

  }
  println(tree.hasPath(TreeEnd, 16))
  println()
}
