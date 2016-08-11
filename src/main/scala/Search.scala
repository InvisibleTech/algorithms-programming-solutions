package org.invisibletech.grokking 

import scala.math.Numeric._

object Search {
  def binarySearch[T](array: Array[T], item: T)(implicit n: Numeric[T]): Option[Int] = {

    def recSearch[T](array: Array[T], item: T, low: Int, high: Int)(implicit n: Numeric[T]): Option[Int] = {
      import n._

      var mid = (high + low) / 2

      if (low <= high) {
        val guess = array(mid)
        guess match {
          case _ if n.gt(guess, item) => recSearch(array, item, low, mid - 1)
          case _ if n.lt(guess, item) => recSearch(array, item, mid + 1, high)
          case _ => Some(mid)
        }

      } else {
        None
      }
    }

    recSearch(array, item, 0, array.length-1)
  }
}