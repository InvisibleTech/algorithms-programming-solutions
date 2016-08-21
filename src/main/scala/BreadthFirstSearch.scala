package org.invisibletech.grokking

import scala.collection.immutable.Queue

object BreadthFirstSearch {
    def existsShortestUnweightedPath[T](start: T, end: T, graph: Map[T, List[T]]): Boolean = {
        def safeGetNeighbors[T](at: T, graph: Map[T, List[T]]): List[T] = {
            graph.get(at) match {
                case Some(l) => l
                case None => List[T]()
            }
        }

        def existsShortestUnweightedPathAux(searchQueue: Queue[T], foundPred: (T) => Boolean, graph: Map[T, List[T]]): Boolean = {
            if (!searchQueue.isEmpty) {
                searchQueue.dequeue match {
                    case (h, t) if (foundPred(h)) => true
                    case (h, t) => existsShortestUnweightedPathAux(t ++ safeGetNeighbors(h, graph), foundPred, graph)
                }
            } else {
                false
            }
        }

        existsShortestUnweightedPathAux(Queue() ++ safeGetNeighbors(start, graph), (x:T) => x == end, graph)
    }
}