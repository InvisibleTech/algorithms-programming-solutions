package org.invisibletech.algorithmsprogrammingsolutions

import org.scalatest.FlatSpec

class PowerFunctionsSpec extends FlatSpec {
  "Powers of 2 by subtraction" should "produce 1, 2, 8, 16, 32 " in {
    val powers = List(0, 1, 2, 3, 4, 5).map(PowerFunctions.pow_sub(2, _))
    assert(powers == List(1, 2, 4, 8, 16, 32))
  }

  "Powers of 2 by decrement by 2" should "produce 1, 2, 8, 16, 32 " in {
    val powers = List(0, 1, 2, 3, 4, 5).map(PowerFunctions.pow_decr_by2(2, _))
    assert(powers == List(1, 2, 4, 8, 16, 32))
  }

  "Powers of 2 by div by 2 deep recursion" should "produce 1, 2, 8, 16, 32 " in {
    val powers = List(0, 1, 2, 3, 4, 5).map(PowerFunctions.pow__div_by_2_superlog(2, _))
    assert(powers == List(1, 2, 4, 8, 16, 32))
  }

  "Powers of 2 by div by 2 modfiy base" should "produce 1, 2, 8, 16, 32 " in {
    val powers = List(0, 1, 2, 3, 4, 5).map(PowerFunctions.pow_lograte(2, _))
    assert(powers == List(1, 2, 4, 8, 16, 32))
  }

  "Powers of 2 by div by 2 modfiy base and use odds accumulator" should "produce 1, 2, 8, 16, 32 " in {
    val powers = List(0, 1, 2, 3, 4, 5).map(PowerFunctions.pow_log_tail(2, _))
    assert(powers == List(1, 2, 4, 8, 16, 32))
  }
}

