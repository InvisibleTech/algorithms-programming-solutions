package org.invisibletech.grokking 

import scala.math.Numeric._

object DivideAndConquer {
    def sum(a: List[Int]): Int = {
        a match {
            case Nil => 0
            case head :: rest => head + sum(rest)
        }
    }

    def count[T](a: List[T]): Int = {
        def count_aux[T](a: List[T], accum: Int) : Int = {
            a match {
                case Nil => accum
                case head :: tail => count_aux(tail, accum + 1)
            }
        }

        count_aux(a, 0)
    }

    def max(a: List[Int]) : Int = {
        def max_aux(a: List[Int], curr_max: Int) : Int = {
            a match {
                case Nil => curr_max
                case head:: tail => max_aux(tail, Math.max(curr_max, head))
            }
        }

        max_aux(a, Int.MinValue)
    }
}