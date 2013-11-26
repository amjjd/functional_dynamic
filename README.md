functional_dynamic
==================

Demonstrates some pure functional dynamic programming techniques.

Presented at the Dublin Scala Users Group meetup on 26 Nov 2013.

fibonacci
---------

Calculating the nth number in the Fibonacci sequence is probably the simplest
example of a problem solvable using dynamic programming. I have provided a
simple recursive implementation that exhibits poor performance due to repeatedly
recomputing the same subproblems. I have provided both a bottom-up table driven
implementation and a version that uses a mutable hash table to memoize its
recursive calls. Finally, I have provided two purely functional memoized
implementations.

count_splits
-----------

This is a simple programming interview question. The input is a string of digits
and a two-digit maximum; the goal is to count the number of different ways the
string can be split into one- or two- digit substrings between one and the
maximum.

For example, with a maximum of 11, `1011` can be split into `10 11` or `10 1 1`.
`1 0 11` is one of several invalid splits.

Again, a simple, poorly-performing version, a bottom-up version and both mutable
hash table and purely functionally memoized versions are provided.

levenshtein_distance
--------------------

The levenshtein distance is a metric of how few edits (insertion, deletion or
substition of a single character) must be made to transform a source string to a
target. It can be used to implement a simple spell checker.

Once again, I have previded a slow recursive version, a bottom-up version and
both mutable hash table and purely functionally memoized versions.

NB
--

These examples carry out little or no input validation, and are both memory- and
processor-inefficient.
