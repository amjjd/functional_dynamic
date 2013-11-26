package com.amjjd.functional_dynamic.fibonacci

import org.scalatest.FunSuite
import org.scalatest.concurrent.Timeouts
import org.scalatest.time.SpanSugar._
import com.amjjd.functional_dynamic.stop

abstract class FibonacciSuite extends FunSuite with Timeouts {
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

  ignore("50") {
    failAfter(5 seconds) {
      assert(fibonacci(50) === 12586269025L)
    }(stop)
  }
}

class SimpleFibonacciSuite extends FibonacciSuite {
  val fibonacci = SimpleFibonacci
}

class BottomUpFibonacciSuite extends FibonacciSuite {
  val fibonacci = BottomUpFibonacci
}

class MemoizedFibonacciSuite extends FibonacciSuite {
  val fibonacci = MemoizedFibonacci
}

class PureFibonacciSuite extends FibonacciSuite {
  val fibonacci = PureFibonacci
}

class StreamFibonacciSuite extends FibonacciSuite {
  val fibonacci = StreamFibonacci
}
