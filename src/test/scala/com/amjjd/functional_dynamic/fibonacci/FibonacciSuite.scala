package com.amjjd.functional_dynamic.fibonacci

import org.scalatest.FunSuite

abstract class FibonacciSuite extends FunSuite {
  def fibonacci: Fibonacci

  test("0") {
    assert(fibonacci(0) === 0L)
  }

  test("1") {
    assert(fibonacci(1) === 1L)
  }

  test("10") {
    assert(fibonacci(10) === 55L)
  }

  /*test("50") {
    assert(fibonacci(50) === 12586269025L)
  }*/
}

class SimpleFibonacciSuite extends FibonacciSuite {
  val fibonacci = SimpleFibonacci
}

/*class BottomUpFibonacciSuite extends FibonacciSuite {
  val fibonacci = BottomUpFibonacci
}

class MemoizedFibonacciSuite extends FibonacciSuite {
  val fibonacci = MemoizedFibonacci
}

class PureFibonacciSuite extends FibonacciSuite {
  val fibonacci = PureFibonacci
}*/
