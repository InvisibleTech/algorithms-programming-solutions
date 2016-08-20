package org.invisibletech.grokking 

import org.scalatest.FlatSpec


class SortSpec extends FlatSpec {
   "Empty array" should "return empty array" in {
      assert(Sort.selectionSort(Array[Int]()) === Array[Int]())
   } 

   "Array with data" should "be sorted" in {
      assert(Sort.selectionSort(Array(3, 2, 1)) === Array(1, 2, 3))
   }
}