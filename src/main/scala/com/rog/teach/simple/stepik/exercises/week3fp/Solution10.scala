package com.rog.teach.simple.stepik.exercises.week3fp


object Solution10 extends App {

  //добавляет локацию в маршрутную сеть
  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    network + (location -> Set())
  }

  //удаляет локацию из маршрутной сети
  def remove(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = {
    import scala.annotation.tailrec
    @tailrec
    def loop(destinations: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (destinations.isEmpty) acc
      else loop(destinations.tail, disconnect(acc, location, destinations.head))
    }

    loop(network(location), network) - location
  }

  //связывает две локации между собой (учитывать, что связь действует в обе стороны, т.е. становится доступным маршрут как туда, так и обратно)
  def connect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    val routesForA: Set[String] = network.getOrElse(pointA, Set())
    val routesForB: Set[String] = network.getOrElse(pointB, Set())
    network + (pointA -> (routesForA + pointB)) + (pointB -> (routesForB + pointA))
  }

  //удаляет маршрут
  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String): Map[String, Set[String]] = {
    var value1 = network.getOrElse(pointA, Set[String]())
    value1 -= pointB
    val result = if (network.contains(pointA)) network + (pointA -> value1) else network
    var value2 = result.getOrElse(pointB, Set[String]())
    value2 -= pointA
    if(result.contains(pointB)) result + (pointB -> value2) else result
  }

  //возвращает количество доступных прямых перелетов из заданной точки
  def nFlights(network: Map[String, Set[String]], location: String): Int = {
    network(location).size
  }

  //возвращает точку, из которой доступно больше всего прямых перелетов
  def mostFlights(network: Map[String, Set[String]]): String = {
    network.view.maxBy(pair => pair._2.size)._1
  }

  //возвращает количество точек, не включенных ни в один маршрут
  def nLocationsWithNoFlights(network: Map[String, Set[String]]): Int = {
    network.view.count(pair => pair._2.isEmpty)
  }

  //проверяет, связаны ли две точки между собой (учитывать возможные пересадки, необходимые чтобы перелететь из одной точки в другую)
  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String): Boolean = {
    //Рекурсивный обход, возвращаюший множество вершин графа
    // adj - наша мапа
    // s - начальная вершина
    // t - пункт назначения
    def bfs[String, R](adj: Map[String, Set[String]], s: String, t: String): Boolean = {
      import scala.collection.mutable
      val queue = mutable.Queue[String]()
      // добавляем s в очередь
      queue += s
      var visited = Set(s)
      while (queue.nonEmpty) {
        // удаляем первый (верхний) элемент из очереди
        val v = queue.dequeue()
        // abj[v] - соседи v
        for (neighbor <- adj.getOrElse(v, Nil)) {
          // если сосед не посещался
          if (!visited.contains(neighbor)) {
            // добавляем его в очередь
            queue += neighbor
            // помечаем вершину как посещенную
            visited += neighbor
            // если сосед является пунктом назначения, мы победили
            if (neighbor == t) return true
          }
        }
      }
      // если t не обнаружено, значит пункта назначения достичь невозможно
      false
    }

    val bool = bfs(network, pointA, pointB)
    if(bool) bool else bfs(network, pointB, pointA)
  }

  //testing
  val map = Map("1" -> Set("123", "1545", "345", "1234534"), "123" -> Set("1923", "1", "19", "29", "49", "349995"), "19" -> Set("1", "123","192113", "19111", "2911", "49111", "349991115"))
  println(remove(map, "123"))
}
