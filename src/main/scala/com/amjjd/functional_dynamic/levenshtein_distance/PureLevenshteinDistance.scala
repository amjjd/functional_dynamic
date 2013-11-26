package com.amjjd.functional_dynamic.levenshtein_distance

import com.amjjd.functional_dynamic.StringMemo

object PureLevenshteinDistance extends LevenshteinDistance {
  def apply(s: String, t: String) = memo(s)(t)

  val memo: StringMemo[StringMemo[Int]] = StringMemo(s => StringMemo(t =>
    if (s.isEmpty) t.length                                                         // need t.length insertions
    else if (t.isEmpty) s.length                                                    // need s.length deletions
    else {
      (PureLevenshteinDistance(s.init, t) + 1) min                                  // min of 1 deletion,
      (PureLevenshteinDistance(s, t.init) + 1) min                                  // 1 insertion, or
      (PureLevenshteinDistance(s.init, t.init) + (if (s.last != t.last) 1 else 0))  // (maybe) 1 substitution
    }
  ))
}
