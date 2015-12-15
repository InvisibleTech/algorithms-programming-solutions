package org.invisibletech.algorithmsprogrammingsolutions

import org.scalatest.FlatSpec

class ComputeProducts1_1_5_Spec extends FlatSpec {
    "Product By + and - with a == 0" should "return 0" in {
        assert(ComputeProducts1_1_5.productBy_+-(0, 10) == 0)
    }

    "Product By + and - with b == 0" should "return 0" in {
        assert(ComputeProducts1_1_5.productBy_+-(10, 0) == 0)
    }

    "Product By + and - with a and b != 0" should "return the products" in {
        val factors = List((1,1), (1, 2), (2, 1), (3, 3), (10, 1), (1, 10), (10, 10))

        val products = factors.map(fs => ComputeProducts1_1_5.productBy_+-(fs._1, fs._2))

        assert(products == List(1, 2, 2, 9, 10, 10, 100))
    }
    "Product By Iteration with a == 0" should "return 0" in {
        assert(ComputeProducts1_1_5.productByIteration_+-(0, 10) == 0)
    }

    "Product By Iteration with b == 0" should "return 0" in {
        assert(ComputeProducts1_1_5.productByIteration_+-(10, 0) == 0)
    }

    "Product By Iteration with a and b != 0" should "return the products" in {
        val factors = List((1,1), (1, 2), (2, 1), (3, 3), (10, 1), (1, 10), (10, 10))

        val products = factors.map(fs => ComputeProducts1_1_5.productByIteration_+-(fs._1, fs._2))

        assert(products == List(1, 2, 2, 9, 10, 10, 100))
    }

}
