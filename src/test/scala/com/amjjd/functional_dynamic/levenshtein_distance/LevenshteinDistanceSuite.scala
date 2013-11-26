package com.amjjd.functional_dynamic.levenshtein_distance

import org.scalatest.FunSuite

abstract class LevenshteinDistanceSuite extends FunSuite {
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
    assert(distance(LoremIpsum, " " + LoremIpsum) === 1)
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
