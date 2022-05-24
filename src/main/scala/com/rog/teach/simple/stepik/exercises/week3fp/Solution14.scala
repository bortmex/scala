package com.rog.teach.simple.stepik.exercises.week3fp
//На предыдущем шаге мы проверяли, существует ли хотя бы один путь, удовлетворяющий условию. Теперь же от вас требуется
// написать метод def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]], который позволит
// получить все имеющиеся в дереве пути от корня до листа, удовлетворяющие заданному условию.
//
//  Условие остается прежним: сумма значений всех узлов, лежащих на найденном пути, должна равняться заданному значению
//  target.
//Если задать target равным 10, то результатом для данного дерева будет List(List(1, 3, 6)).
//Естественно, для проверки совпадения суммы значений узлов с target вам потребуется вычислить сумму (или разность -
// зависит от выбранного вами подхода к решению) двух чисел. Для этого придется конвертировать String в Int. Так
// попробуйте сделать это без использования готовых библиотек и методов вроде .toInt. Вместо этого напишите свою функцию
// def yourFunction(a: String, b: String), которая производит необходимые вычисления (вне этой функции можете свободно
// прибегать к стандартным методам конвертации).
//
//
//
//  Примечания:
//
//  Подсказка к заданию по конвертации будет закреплена в комментарии ниже. При желании можете ей воспользоваться.
//  Чтобы сильно не перегружать код, будут использованы только положительные числа, и не будет сюрпризов вроде лишних
//  пробелов в строке.
//  Как и в прошлом задании, в системе заранее прописан уже знакомый вам класс BinaryTree, Node, TreeEnd. Следовательно,
//  вам доступны методы: value, leftChild, rightChild, isEmpty, isLeaf
//  принтить результаты не надо, напишите только требуемый метод
//  решение можно реализовать как в виде обычной рекурсии, так и в виде хвостовой. В этом задании мы не настаиваем, лишь
//  советуем хвостовую рекурсию, выбор способа решения остается за вами.
//  договоримся, что сначала мы ищем возможные пути слева, затем справа, а значения узлов добавляются в список по мере
//  прохождения дерева сверху вниз.
//  пример финального списка: List(List(найденный пусть слева), List(найденный пусть справа))
object Solution14 extends App {

  abstract class BinaryTree[+T] {
    def value: T

    def leftChild: BinaryTree[T]

    def rightChild: BinaryTree[T]

    def isEmpty: Boolean

    def isLeaf: Boolean

    def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]]
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException

    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def isLeaf: Boolean = false

    override def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]] = List()
  }

//  val tree = Node("1",
//    Node("2",
//      Node("4",
//        TreeEnd,
//        TreeEnd),
//      Node("5",
//        TreeEnd,
//        Node("8",
//          TreeEnd,
//          TreeEnd))),
//    Node("3",
//      Node("6",
//        TreeEnd,
//        TreeEnd),
//      Node("7",
//        TreeEnd,
//        TreeEnd))
//  )
val tree = Node("1",
  Node("12",
    Node("4",
      TreeEnd,
      Node("8",
        TreeEnd,
        TreeEnd)),
    Node("5",
      TreeEnd,
      TreeEnd)),
  Node("3",
    Node("21",
      TreeEnd,
      TreeEnd),
    Node("7",
      TreeEnd,
      TreeEnd))
)
  case class Node[+T](
                       override val value: T,
                       override val leftChild: BinaryTree[T],
                       override val rightChild: BinaryTree[T])
    extends BinaryTree[T] {
    override def isEmpty: Boolean = false

    override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty

    override def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]] = {
      var listresult = Map[String, List[List[String]]]()
      import scala.annotation.tailrec
      //@tailrec
      if(tree.isEmpty){
        return List()
      }

      def sum(list: List[String]): String = {
        list.map(x=>x.toInt).sum.toString
      }

      def loop(queue: List[BinaryTree[String]] = List[BinaryTree[String]](tree),
               listListResult: List[String] = List(tree.value)): Unit = {

        if (!queue.head.leftChild.isEmpty) {
          loop(queue.head.leftChild +: queue.tail, listListResult :+ queue.head.leftChild.value)
        }
        if (!queue.head.rightChild.isEmpty) {
          loop(queue.head.rightChild +: queue.tail, listListResult :+ queue.head.rightChild.value)
        }
        if(queue.head.isLeaf) {
          val localResult = listresult.getOrElse(sum(listListResult), Nil)
          if(localResult != Nil) {
            listresult += (sum(listListResult) -> (localResult ::: List(listListResult)))
          }
          else
          listresult += sum(listListResult) -> List(listListResult)
        }
      }
      loop()
      listresult.getOrElse(target, List())
    }
  }
  println(tree.findAllPaths(tree, "25"))
  println()
}
