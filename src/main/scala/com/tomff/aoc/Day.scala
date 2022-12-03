package com.tomff.aoc

import scala.io.Source
import scala.util.{Try, Using}

trait Day(val num: Int) {
  private val inputPath: String = s"input/$num"

  def solve(input: Seq[String]): (Int, Int)

  def run(): Try[(Int, Int)] =
    Using(Source.fromResource(inputPath)) {
      reader => solve(reader.getLines().toSeq)
    }
}
