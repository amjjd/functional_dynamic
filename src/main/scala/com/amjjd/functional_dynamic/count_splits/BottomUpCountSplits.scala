package com.amjjd.functional_dynamic.count_splits

class BottomUpCountSplits(max: String) extends CountSplitsWithMax {
  def apply(str: String): Long = {
    val n = str.length max 1
    val c = Array.ofDim[Long]((n + 1))

    c(n) = 1                                      // only one way to split an empty string, or
    c(n - 1) = 1                                  // a single digit string

    for (i <- (n - 2) to 0 by -1) {
      c(i) = if (str.slice(i, i + 2) <= max) {
        c(i + 2) +                                // can split into a two-digit number and a tail, and
        (if (str(i + 1) != '0') c(i + 1) else 0L) // may be able to split into a one-digit number and a tail
      }
      else c(i + 1)                               // can only split into a one-digit number and a tail
    }

    c(0)
  }
}
