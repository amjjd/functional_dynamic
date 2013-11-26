package com.amjjd.functional_dynamic.fibonacci

object SimpleFibonacci extends Fibonacci {
  def apply(n: Int): Long = n match {
    case 0 => 0
    case 1 => 1
    case _ => SimpleFibonacci(n - 2) + SimpleFibonacci(n - 1)
  }
}
