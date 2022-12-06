package com.tomff.aoc.days

import com.tomff.aoc.Day

object Day6 extends Day(6) {
  private def findPacketMarkerStart(input: String, markerLength: Int): Int =
    input.sliding(markerLength).zipWithIndex.find(
      (packet, _) => packet.distinct.length == packet.length
    ).map(_._2).get + markerLength

  override def solve(input: Seq[String]): (Int, Int) = {
    (findPacketMarkerStart(input.head, 4), findPacketMarkerStart(input.head, 14))
  }
}
