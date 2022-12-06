package com.tomff.aoc.days

import com.tomff.aoc.Day

object Day6 extends Day(6) {
  private def findPacketMarkerStart(input: Seq[Char], markerLength: Int): Int =
    input.sliding(markerLength).indexWhere(
      p => p.distinct.length == p.length
    ) + markerLength

  override def solve(input: Seq[String]): (Int, Int) =
    (findPacketMarkerStart(input.flatten, 4), findPacketMarkerStart(input.flatten, 14))
}
