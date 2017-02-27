package org.invisibletech.grokking

import scala.collection.immutable.Queue
import scala.annotation.tailrec
import scala.collection.mutable.Map

case class Node(name: String, adjacents: List[String])

class Graph {
  val registry: Map[String, Node] = Map()

  implicit def NodeToKVTuple(n : Node): (String, Node) =  (n.name, n)

  def createNode(values: List[String]): Option[Node] = {
    values match {
      case name::adjacents => Some(Node(name, adjacents))
      case Seq() => None
    }
  }

  def register(data: List[List[String]]): Graph  = {
    data.map(createNode(_)).filter(!_.isEmpty).map(_.get).foldLeft(registry) (
      (r: Map[String, Node], n: Node) => r += n)

    this
  }

  def getAdjacents(key: String): List[String] = {
    registry.get(key) match {
      case Some(n) => n.adjacents
      case None => List[String]()
    }
  }
}

object BreadthFirstSearchWithNode {
  def existsShortestUnweightedPath(start: String, end: String, graph: Graph): Boolean = {
    @tailrec
    def existsSUPAux(searchQueue: Queue[String], beenThere: List[String], foundPred: (String) => Boolean, graph: Graph): Boolean = {
      if (!searchQueue.isEmpty) {
        searchQueue.dequeue match {
          case (h, t) if (foundPred(h)) => true
          case (h, t) if (beenThere.contains(h)) => existsSUPAux(t, beenThere, foundPred, graph)
          case (h, t) => existsSUPAux(t ++ graph.getAdjacents(h), beenThere :+ h, foundPred, graph)
        }
      } else {
        false
      }
    }

    existsSUPAux(Queue() ++ graph.getAdjacents(start), List(start), (x: String) => x == end, graph)
  }
}
