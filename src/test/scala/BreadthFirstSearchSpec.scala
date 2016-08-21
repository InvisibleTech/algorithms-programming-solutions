package org.invisibletech.grokking

import org.scalatest.FlatSpec

class BreadthFirstSearchSpec() extends FlatSpec {
   "Empty map" should "return false" in {
      assert(BreadthFirstSearch.existsShortestUnweightedPath("Here", "There", Map()) === false)
   } 

   "Start not in map" should "return false" in {
      assert(BreadthFirstSearch.existsShortestUnweightedPath("Here", "There", 
                                                                Map[String, List[String]](
                                                                "There" -> List("Tokyo", "Paris"), 
                                                                "Moscow" -> List("Istanbul", "Vienna", "Paris"))) === false)
   } 

   "End not in map" should "return false" in {
      assert(BreadthFirstSearch.existsShortestUnweightedPath("Here", "Timbuktu", 
                                                                Map[String, List[String]](
                                                                "Here" -> List("Tokyo", "Paris"), 
                                                                "Moscow" -> List("Istanbul", "Vienna", "Paris"))) === false)
   } 

   "Destination is only neighbor" should "true" in {
      assert(BreadthFirstSearch.existsShortestUnweightedPath("Here", "Timbuktu", 
                                                                Map[String, List[String]](
                                                                "Here" -> List("Timbuktu"), 
                                                                "Timbuktu" -> List("Istanbul", "Vienna", "Paris"))) === true)
   }


   "Destination is only 2nd degree neighbor" should "true" in {
      assert(BreadthFirstSearch.existsShortestUnweightedPath("Here", "Timbuktu", 
                                                                Map[String, List[String]](
                                                                "Here" -> List("Moscow"), 
                                                                "Moscow" -> List("Timbuktu"))) === true)
   } 

   "Destination is the last 2nd degree neighbor" should "true" in {
      assert(BreadthFirstSearch.existsShortestUnweightedPath("Here", "Timbuktu", 
                                                                Map[String, List[String]](
                                                                "Here" -> List("Moscow", "Paris"),
                                                                "Paris" -> List("New York", "Mexico City"),
                                                                "Mexico City" -> List("Delhi"),
                                                                "Delhi" -> List("Timbuktu", "New York"), 
                                                                "Moscow" -> List("Paris", "Timbuktu"))) === true)
   } 
 
}