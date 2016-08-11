package org.invisibletech.grokking 

import org.scalatest.FlatSpec

class SearchSpec extends FlatSpec {
   "Empty array" should "return None" in {
      assert(Search.binarySearch(Array[Int](), 10) == None)
   } 

   "Item not in array" should "return None" in {
      assert(Search.binarySearch(Array[Int](1, 2, 3), 5) == None)
   }

   "Item in array" should "return Some(index)" in {
      assert(Search.binarySearch(Array[Double](3.3, 5.5, 100.4, 10000.0), 100.4) == Some(2))
   }
}