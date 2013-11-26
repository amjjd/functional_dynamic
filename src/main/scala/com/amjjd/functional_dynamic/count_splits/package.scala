package com.amjjd.functional_dynamic

package object count_splits {
  /**
   * Takes a a two-digit maximum and a string of digits, and returns the number of ways the string can be split into
   * one- or two- digit numbers no greater than the  than the maximum and without zero-padding.
   */
  type CountSplits = String => CountSplitsWithMax
  private[count_splits] type CountSplitsWithMax = (String => Long)
}
