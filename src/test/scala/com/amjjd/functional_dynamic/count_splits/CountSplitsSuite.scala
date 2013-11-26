package com.amjjd.functional_dynamic.count_splits

import org.scalatest.FunSuite

abstract class CountSplitsSuite extends FunSuite {
  def splits: CountSplits

  test("12, 10296112") {
    assert(splits("12")("10296112") === 3L)
  }

  test("10, 10296112") {
    assert(splits("10")("10296112") === 1L)
  }

  test("10, 1") {
    assert(splits("10")("1") === 1L)
  }

  test("10, <nil>") {
    assert(splits("10")("") === 1L)
  }

  ignore("11, <45 1s>") {
    assert(splits("11")(List.fill(45)('1').mkString) === 1836311903L)
  }
}

class SimpleCountSplitsSuite extends CountSplitsSuite {
  val splits = new SimpleCountSplits(_)
}

class BottomUpCountSplitsSuite extends CountSplitsSuite {
  val splits = new BottomUpCountSplits(_)
}

class MemoizedCountSplitsSuite extends CountSplitsSuite {
  val splits = new MemoizedCountSplits(_)
}

class PureCountSplitsSuite extends CountSplitsSuite {
  val splits = new PureCountSplits(_)
}
