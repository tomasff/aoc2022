package com.tomff.aoc.days

import com.tomff.aoc.Day

object Day6 extends Day(6) {
  private def findPacketMarkerStart(input: Seq[Char], markerLength: Int): Int =
    input.sliding(markerLength).zipWithIndex.find(
      (packet, _) => packet.distinct.length == packet.length
    ).map(_._2 + markerLength).getOrElse(-1)

  override def solve(input: Seq[String]): (Int, Int) = {
    (findPacketMarkerStart(input.flatten, 4), findPacketMarkerStart(input.flatten, 14))
  }
}
