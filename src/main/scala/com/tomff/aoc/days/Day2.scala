package com.tomff.aoc.days

import com.tomff.aoc.Day

object Day2 extends Day(2) {
  private def scoreForPlay(play: String): Int =
    play match {
      case "X" | "A" => 1
      case "Y" | "B" => 2
      case "Z" | "C" => 3
    }

  private def scoreForHead2Head(opponent: String, us: String): Int =
    (opponent, us) match {
      case ("A", "X") | ("B", "Y") | ("C", "Z") => 3
      case ("A", "Y") | ("B", "Z") | ("C", "X") => 6
      case (_, _) => 0
    }

  private def calculateRoundScore(round: String): Int =
    round.split(" ") match {
      case Array(opponent, us) => scoreForPlay(us) + scoreForHead2Head(opponent, us)
    }

  private def winningPlay(play: String): String =
    play match {
      case "A" => "Y"
      case "B" => "Z"
      case "C" => "X"
    }

  private def loosingPlay(play: String): String =
    play match {
      case "A" => "Z"
      case "B" => "X"
      case "C" => "Y"
    }

  private def scoreForOutcome(opponent: String, outcome: String): Int =
    outcome match {
      case "X" => 0 + scoreForPlay(loosingPlay(opponent))
      case "Y" => 3 + scoreForPlay(opponent)
      case "Z" => 6 + scoreForPlay(winningPlay(opponent))
    }

  private def calculateRoundScoreForOutcomes(round: String): Int =
   round.split(" ") match {
     case Array(opponent, outcome) => scoreForOutcome(opponent, outcome)
   }

  override def solve(input: Iterator[String]): (Int, Int) =
    input.map {
      round => (calculateRoundScore(round), calculateRoundScoreForOutcomes(round))
    }.reduce {
      (x, y) => (x._1 + y._1, x._2 + y._2)
    }
}
