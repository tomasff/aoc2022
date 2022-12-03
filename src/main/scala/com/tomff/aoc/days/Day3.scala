package com.tomff.aoc.days

import com.tomff.aoc.Day

object Day3 extends Day(3) {
  private def itemPriority(item: Char): Int = if (item.isLower) {
    item.toByte - 97 + 1
  } else {
    item.toByte - 65 + 27
  }

  private def findCommonItemsScore(first: String, second: String): Int =
    (first intersect second).distinct.map(itemPriority).sum

  private def findRucksacksPrioritySum(input: Seq[String]): Int =
    input.map {
      rucksack => rucksack.splitAt(rucksack.length / 2)
    }.map(findCommonItemsScore).sum

  private def findSumElfGroupPriorities(input: Seq[String]): Int =
    input.grouped(3).map {
      elfGroup => {
        elfGroup.reduce((x, y) => x intersect y).head
      }
    }.map(itemPriority).sum

  override def solve(input: Seq[String]): (Int, Int) =
    (findRucksacksPrioritySum(input), findSumElfGroupPriorities(input))
}
