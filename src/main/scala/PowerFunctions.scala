package org.invisibletech.algorithmsprogrammingsolutions

object PowerFunctions {
  // a ^ n = a * a * ... a  n times n > 0   or 1 if n = 0 
  def pow_sub(a: Int, n: Int): Int = n match {
    case 0 => 1
    case k => a * pow_sub(a, k - 1)
  }

  //      a^0 = 1
  // a^n  a^k = a*a * a*a ... a*a, k times a*a where k is a mutiple of 2 such that k = n div 2
  //      a^n = a * a^k, where n is odd so k is even, a multiple of 2 such that k = n div 2  
  def pow_decr_by2(a: Int, n: Int): Int = {
    n match {
      case 0 => 1
      case k if ((k % 2) == 0) => a * a * pow_decr_by2(a, n - 2)
      case _ => a * pow_decr_by2(a, n - 1)
    }
  }

  //
  //  Now we need a function that works for this that is recursive, fewer cases, elegant but not
  //  efficient.  Not even close.  In fact, awful.
  //
  def pow__div_by_2_superlog(a: Int, n: Int): Int = {
    println(s"Entering with $a ^ $n ")

    n match {
      case 0 => 1
      case k if ((k % 2) == 0) => pow__div_by_2_superlog(a, n >> 1) * pow__div_by_2_superlog(a, n >> 1)
      case _ => a * pow__div_by_2_superlog(a, n - 1)
    }
  }

  // Parts of this I had earlier, but something wasn't right.  After coming back around 
  // to someting worse than log n for performance - above, looked at 
  // https://en.wikipedia.org/wiki/Exponentiation_by_squaring#Computational_complexity
  //
  // Once again took to the idea of modifying an input and adding special case 1... closer to
  // log2 n now.  The key I was missing was the precomputation of a^2 in the odd case.  That
  // was it.
  //
  def pow_lograte(a: Int, n: Int): Int = {
    println(s"Entering with $a ^ $n")
    n match {
      case 0 => 1
      case 1 => a
      case k if ((k % 2) == 0) => pow_lograte(a * a, n >> 1)
      case _ => a * pow_lograte(a * a, (n - 1) >> 1)
    }

  }

  // Now https://en.wikipedia.org/wiki/Exponentiation_by_squaring#Computational_complexity
  // Discussed tail recursion, and it uses something I had tried earlier to get log2 n performance
  // which is an odd accumulator for odd power computations.  Until I saw the link above I
  // was missing the even reduction in the odd case and return the odd accumulator for the n = 0 case.
  // I had everything else.
  import scala.annotation.tailrec
  def pow_log_tail(a: Int, n: Int): Int = {
    println(s"Starting with $a ^ $n")

    @tailrec
    def pow_tail(y: Int, a: Int, n: Int): Int = {
      println(s"Tail Starting with $y * $a ^ $n")
      n match {
        case 0 => y
        case 1 => y * a
        case k if ((k % 2) == 0) => pow_tail(y, a * a, n >> 1)
        case _ => pow_tail(a * y, a * a, (n - 1) >> 1)
      }

    }

    pow_tail(1, a, n)
  }
}
