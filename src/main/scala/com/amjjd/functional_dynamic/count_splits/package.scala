package com.amjjd.functional_dynamic

package object count_splits {
  /**
   * Takes a a two-digit maximum and a string of digits, and returns the number of different ways the string can be
   * split into one- or two- digit substrings between one and the maximum.
   *
   * For example, with a maximum of `11`, `1011` can be split into `10 11` or `10 1 1`.
   * `1 0 11` is one of several invalid splits.
   */
  type CountSplits = String => CountSplitsWithMax
  private[count_splits] type CountSplitsWithMax = (String => Long)
}
