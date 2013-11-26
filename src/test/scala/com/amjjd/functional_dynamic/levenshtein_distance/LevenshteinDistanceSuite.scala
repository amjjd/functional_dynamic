package com.amjjd.functional_dynamic.levenshtein_distance

import org.scalatest.FunSuite
import org.scalatest.concurrent.Timeouts
import org.scalatest.time.SpanSugar._
import com.amjjd.functional_dynamic.stop

abstract class LevenshteinDistanceSuite extends FunSuite with Timeouts {
  def distance: LevenshteinDistance

  test("kitten -> sitting") {
    assert(distance("kitten", "sitting") === 3)
  }

  test("sitting -> kitten") {
    assert(distance("sitting", "kitten") === 3)
  }

  test("empty source") {
    assert(distance("", "a") == 1)
  }

  test("empty target") {
    assert(distance("a", "") == 1)
  }

  test("same") {
    assert(distance("a", "a") == 0)
  }

  test("both empty") {
    assert(distance("", "") == 0)
  }

  ignore("lorem ipsum") {
    failAfter(5 seconds) {
      assert(distance(LoremIpsum, " " + LoremIpsum) === 1)
    }(stop)
  }

  val LoremIpsum = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut"
}

class SimpleLevenshteinDistanceSuite extends LevenshteinDistanceSuite {
  val distance = SimpleLevenshteinDistance
}

class BottomUpLevenshteinDistanceSuite extends LevenshteinDistanceSuite {
  val distance = BottomUpLevenshteinDistance
}

class MemoizedLevenshteinDistanceSuite extends LevenshteinDistanceSuite {
  val distance = MemoizedLevenshteinDistance
}

class PureLevenshteinDistanceSuite extends LevenshteinDistanceSuite {
  val distance = PureLevenshteinDistance
}
