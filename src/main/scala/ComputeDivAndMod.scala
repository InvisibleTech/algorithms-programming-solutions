package org.invisibletech.algorithmsprogrammingsolutions

// Per the problem the dividend is a non-negative integer while the 
// divisor is a positive integer.
object ComputeDivAndMod {
    def divAndMod(a: Int, d: Int): Tuple2[Int, Int] = {
        def divAndModAux(a: Int, d: Int, q:Int): Tuple2[Int, Int] = {
            if (d > a)
                Tuple2(q, a)
            else
                divAndModAux(a - d, d, q + 1)
        }

        divAndModAux(a, d, 0)
    }
}