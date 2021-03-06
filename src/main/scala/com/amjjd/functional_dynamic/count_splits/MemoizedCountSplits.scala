package com.amjjd.functional_dynamic.count_splits

import scala.collection.mutable

class MemoizedCountSplits(max: String) extends CountSplitsWithMax {
  def apply(str: String): Long = memo.getOrElseUpdate(str, {
    if (str.length <= 1) 1L                           // only one way to split an empty or single digit string
    else if (str.take(2) <= max) {
      apply(str.drop(2)) +                            // can split into a two-digit number and a tail, and
      (if (str(1) != '0') apply(str.drop(1)) else 0L) // may be able to split into a one-digit number and a tail
    }
    else apply(str.drop(1))                           // can only split into a one-digit number and a tail
  })

  private val memo: mutable.Map[String, Long] = mutable.Map.empty
}
