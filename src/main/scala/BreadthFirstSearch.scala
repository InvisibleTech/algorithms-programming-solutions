package org.invisibletech.grokking

import scala.collection.immutable.Queue
import scala.annotation.tailrec

object BreadthFirstSearch {
    def existsShortestUnweightedPath[T](start: T, end: T, graph: Map[T, List[T]]): Boolean = {
        def safeGetNeighbors[T](at: T, graph: Map[T, List[T]]): List[T] = {
            graph.get(at) match {
                case Some(l) => l
                case None => List[T]()
            }
        }

        @tailrec
        def existsShortestUnweightedPathAux(searchQueue: Queue[T], beenThere: List[T], foundPred: (T) => Boolean, graph: Map[T, List[T]]): Boolean = {
            if (!searchQueue.isEmpty) {
                searchQueue.dequeue match {
                    case (h, t) if (foundPred(h)) => true
                    case (h, t) if (beenThere.contains(h)) => existsShortestUnweightedPathAux(t, beenThere, foundPred, graph)
                    case (h, t) => existsShortestUnweightedPathAux(t ++ safeGetNeighbors(h, graph), beenThere :+ h, foundPred, graph)
                }
            } else {
                false
            }
        }

        existsShortestUnweightedPathAux(Queue() ++ safeGetNeighbors(start, graph), List(start), (x:T) => x == end, graph)
    }
}
