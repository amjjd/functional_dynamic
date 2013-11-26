package com.amjjd.functional_dynamic.levenshtein_distance

import scala.collection.mutable

object MemoizedLevenshteinDistance extends LevenshteinDistance {
  def apply(s: String, t: String): Int = memo.getOrElseUpdate((s, t), {
    if (s.isEmpty) t.length                                                             // need t.length insertions
    else if (t.isEmpty) s.length                                                        // need s.length deletions
    else {
      (MemoizedLevenshteinDistance(s.init, t) + 1) min                                  // min of 1 deletion,
      (MemoizedLevenshteinDistance(s, t.init) + 1) min                                  // 1 insertion, or
      (MemoizedLevenshteinDistance(s.init, t.init) + (if (s.last != t.last) 1 else 0))  // (maybe) 1 substitution
    }
  })

  private val memo: mutable.Map[(String, String), Int] = mutable.Map.empty
}
