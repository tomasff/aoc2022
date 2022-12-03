package com.tomff.aoc

import com.tomff.aoc.days._

val solvedDays = Vector(Day2)
@main
def main(): Unit =
  println(
    solvedDays.map {
      day =>
        s"""Day ${day.num}
           |Result: ${day.run().getOrElse("Failed")}""".stripMargin
    }.mkString("\n")
  )