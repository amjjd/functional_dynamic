package com.amjjd.functional_dynamic

package object fibonacci {
  type Fibonacci = Int => Long

  val PureFibonacci: Fibonacci = IntMemo.nonNegative {
    case 0 => 0L
    case 1 => 1L
    case n => PureFibonacci(n - 2) + PureFibonacci(n - 1)
  }

  val StreamFibonacci: Stream[Long] = 0L #:: 1L #:: (StreamFibonacci zip StreamFibonacci.tail).map(ns => ns._1 + ns._2)
}
