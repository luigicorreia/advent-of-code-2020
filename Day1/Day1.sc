import scala.io.Source

val filename="/Users/correial/Documents/Advent of Code/2020/Day1/input.txt"

val numbers = Source.fromFile(filename).getLines.toList

// Answer 1 - 388075
val combinations1 = numbers.flatMap(n1 => numbers.map(n2 => if(n1.toInt + n2.toInt == 2020) n1.toInt * n2.toInt else 0)).filter(_ > 0).distinct

// Answer 2 - 293450526
val combinations2 = numbers.flatMap(n1 => numbers.flatMap(n2 => numbers.map(n3 => if(n1.toInt + n2.toInt + n3.toInt == 2020) n1.toInt * n2.toInt * n3.toInt else 0))).filter(_ > 0).distinct




