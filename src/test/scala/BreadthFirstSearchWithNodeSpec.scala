package org.invisibletech.grokking

import org.scalatest.FlatSpec
import scala.annotation.tailrec
import scala.collection.immutable.Queue

import org.invisibletech.grokking.BreadthFirstSearchWithNode._

class BreadthFirstSearchWithNodeSpec() extends FlatSpec {
  "Empty List" should "return empty registry" in {
    assert(new Graph().register(List[List[String]]()).registry === Map())
  }

  "List with empty lists" should "return empty registry" in {
    assert(new Graph().register(List[List[String]](List[String]())).registry === Map())
  }

  "List with some empty lists" should "return non-empty registry" in {
    assert(new Graph().register(List[List[String]](List(), List("Here", "There"))).registry === Map(("Here" -> Node("Here", List("There")))))
  }

  "Empty map" should "return false" in {
    assert(BreadthFirstSearchWithNode.existsShortestUnweightedPath("Here", "There", new Graph().register(List[List[String]]())) === false)

  }

  "Destination is only neighbor" should "return true" in {
    assert(BreadthFirstSearchWithNode.existsShortestUnweightedPath("Here", "Timbuktu",
        new Graph().register(List(List("Here", "Timbuktu"),
        List("Timbuktu", "Istanbul", "Vienna", "Paris"))))
      === true)
  }
}
