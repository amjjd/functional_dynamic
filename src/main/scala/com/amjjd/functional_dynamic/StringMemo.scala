package com.amjjd.functional_dynamic

class StringMemo[T] private (prefix: String, V: String => T) extends (String => T) {
  private[this] val m = new IntMemo(0, 65535, c => new StringMemo(prefix + c.toChar, V))

  private[this] lazy val value = V(prefix)

  def apply(x: String): T =
    if (x.isEmpty) value
    else m(x.head)(x.tail)
}

object StringMemo {
  def apply[T](V: String => T): StringMemo[T] = new StringMemo("", V)
}
