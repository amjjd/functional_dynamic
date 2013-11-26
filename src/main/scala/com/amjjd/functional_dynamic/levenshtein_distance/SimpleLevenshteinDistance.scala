package com.amjjd.functional_dynamic.levenshtein_distance

object SimpleLevenshteinDistance extends LevenshteinDistance {
  def apply(s: String, t: String): Int = {
    if (s.isEmpty) t.length                                                           // need t.length insertions
    else if (t.isEmpty) s.length                                                      // need s.length deletions
    else {
      (SimpleLevenshteinDistance(s.init, t) + 1) min                                  // min of 1 deletion,
      (SimpleLevenshteinDistance(s, t.init) + 1) min                                  // 1 insertion, or
      (SimpleLevenshteinDistance(s.init, t.init) + (if (s.last != t.last) 1 else 0))  // (maybe) 1 substitution
    }
  }
}
