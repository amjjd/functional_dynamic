package com.amjjd.functional_dynamic.fibonacci

object BottomUpFibonacci extends Fibonacci {
  def apply(n: Int): Long = {
    val f = Array.ofDim[Long]((n + 1) max 2)

    f(0) = 0L
    f(1) = 1L
    for (i <- 2 to n) f(i) = f(i - 2) + f(i - 1)

    f(n)
  }
}
