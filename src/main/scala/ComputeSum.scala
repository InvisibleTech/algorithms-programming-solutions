package org.invisibletech.algorithmsprogrammingsolutions

import scala.annotation.tailrec

object ComputeSum {
    def sum_rec(a: Int, b: Int) :Int = {
        @tailrec
        def sum_rec_aux(a: Int, b:Int, iter: Int) : Int = {
            if (iter == b) 
                a
            else 
                sum_rec_aux(a + 1, b, iter + 1)
        }

        sum_rec_aux(a, b, 0)
    }
}