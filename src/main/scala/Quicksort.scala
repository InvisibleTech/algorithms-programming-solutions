package org.invisibletech.grokking

object Quicksort {
  def sort(a: Array[Int]): Array[Int] = {
    if (a.length < 2) {
      a
    } else {
      val pivot = a(scala.util.Random.nextInt(a.length))

      Array.concat(sort(a.filter(x => x < pivot)),
        a.filter(x => x == pivot),
        sort(a.filter(x => x > pivot)))
    }

  }
}