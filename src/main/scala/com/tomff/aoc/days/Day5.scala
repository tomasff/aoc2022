package com.tomff.aoc.days

import com.tomff.aoc.Day

object Day5 extends Day(5) {

  def part1(input: Seq[String]): Int = {
    val separatorPosition = input.indexWhere(_.isEmpty)
    val stacksState = input take separatorPosition
    val moves = input drop (separatorPosition + 1)

    val stacks = stacksState.last.split(" ")

    stacksState.reverseIterator.drop(1).map {

    }

    0
  }
  override def solve(input: Seq[String]): (Int, Int) =
    (part1(input), 0)

}
