package com.amjjd.functional_dynamic.levenshtein_distance

object BottomUpLevenshteinDistance extends LevenshteinDistance {
  def apply(s: String, t: String): Int = {
    val d = Array.ofDim[Int](s.length + 1, t.length + 1)

    for (j <- 1 to t.length) d(0)(j) = j                            // empty s needs (prefix of t).length insertions

    for (i <- 1 to s.length) {
      d(i)(0) = i                                                   // empty t needs (prefix of s).length deletions
      for (j <- 1 to t.length) {
        d(i)(j) = {
          (d(i - 1)(j) + 1) min                                     // min of 1 deletion,
          (d(i)(j - 1) + 1) min                                     // 1 insertion, or
          (d(i - 1)(j - 1) + (if (s(i - 1) != t(j - 1)) 1 else 0))  // (maybe) 1 substitution
        }
      }
    }

    d(s.length)(t.length)
  }
}
