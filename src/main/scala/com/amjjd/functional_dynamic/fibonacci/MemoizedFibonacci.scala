package com.amjjd.functional_dynamic.fibonacci

import scala.collection.mutable

object MemoizedFibonacci extends Fibonacci {
  def apply(n: Int): Long = memo.getOrElseUpdate(n, { n match {
    case 0 => 0L
    case 1 => 1L
    case _ => MemoizedFibonacci(n - 2) + MemoizedFibonacci(n - 1)
  }})

  private val memo: mutable.Map[Int, Long] = mutable.Map.empty
}
