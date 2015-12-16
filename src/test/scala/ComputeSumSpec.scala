package org.invisibletech.algorithmsprogrammingsolutions

import org.scalatest.FlatSpec

class ComputeSumSpec extends FlatSpec {
    "Sum b == 0" should "return a" in {
        List(0, 1, 2, 3).map(a =>  assert(ComputeSum.sum_rec(a, 0) == a))
    }

    "Sum a == 0" should "return b" in {
        List(0, 1, 2, 3).map(b =>  assert(ComputeSum.sum_rec(0, b) == b))
    }

    "Sum given a + b = 10" should "return 10" in {
        List((0, 10), (1, 9), (2, 8), (3, 7)).map(p =>  assert(ComputeSum.sum_rec(p._1, p._2) == 10))
    }
}
