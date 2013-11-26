package com.amjjd.functional_dynamic

class IntMemo[T](low: Int, high: Int, V: Int => T) extends (Int => T) {
  private[this] val key = low + (high - low) / 2
  private[this] lazy val left = new IntMemo(low, key - 1, V)
  private[this] lazy val right = new IntMemo(key + 1, high, V)

  private[this] lazy val value = V(key)

  def apply(x: Int): T =
    if (x == key) value
    else if (x < key) left(x)
    else right(x)
}

object IntMemo {
  def apply[T](V: Int => T) = new IntMemo(Int.MinValue, Int.MaxValue, V)

  def nonNegative[T](V: Int => T) = new IntMemo(0, Int.MaxValue, V)
  def positive[T](V: Int => T) = new IntMemo(0, Int.MaxValue, V)
}
