package org.invisibletech.algorithmsprogrammingsolutions

import org.scalatest.FlatSpec

// Per the problem the dividend is a non-negative integer while the 
// divisor is a positive integer.
class ComputeDivAndModSpec extends FlatSpec {
    "a div d given a < d" should "return q = 0 and r = a" in {
        assert(ComputeDivAndMod.divAndMod(5, 6) == Tuple2(0, 5))
    }

    "a div d given a = 0 and d = 1" should "return q = 0 and r = 0" in {
        assert(ComputeDivAndMod.divAndMod(0, 1) == Tuple2(0, 0))
    } 

    "a div d given a = d * 3" should "return q = 3 and r = 0" in {
        assert(ComputeDivAndMod.divAndMod(6, 2) == Tuple2(3, 0))
    } 

    "a div d given a = d * 3 + 2" should "return q = 3 and r = 2" in {
        assert(ComputeDivAndMod.divAndMod(17, 5) == Tuple2(3, 2))
    } 

    "a div d given a = d * 3 + (d - 1)" should "return q = 3 and r = d - 1" in {
        assert(ComputeDivAndMod.divAndMod(19, 5) == Tuple2(3, 4))
    } 

}
