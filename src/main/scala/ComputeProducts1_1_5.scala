package org.invisibletech.algorithmsprogrammingsolutions

object ComputeProducts1_1_5 {
    def productBy_+- (a:Int, b:Int) :Int = {
        a match {
            case 0 => 0
            case _ if b == 0 => 0
            case a if b != 0 => a + productBy_+-(a, b - 1)
        }
    }

    // This is based on the author's answer in Pascal
    def productByIteration_+-(a: Int, b: Int): Int = {
        var result = 0
        var counts = 0

        while (counts != b) {
            result += a
            counts += 1
        }

        result
    }
}