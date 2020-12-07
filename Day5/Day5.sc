val filename="/Users/correial/Documents/Advent of Code/2020/Day5/input.txt"
val tickets = io.Source.fromFile(filename).getLines().toList

// PART 1
case class Seats(rows: (Int, Int), cols: (Int, Int), r: Int, c: Int)
val seats = Seats((0,127), (0,7), 0, 0)

def fold(s: String): Seats = s.foldLeft(seats){(seats, char) => char match {
  case 'F' => Seats((seats.rows._1, seats.rows._2 - ((seats.rows._2 - seats.rows._1 + 1) / 2)), seats.cols, seats.rows._1, seats.c)
  case 'B' => Seats((seats.rows._1 + ((seats.rows._2 - seats.rows._1 + 1) / 2), seats.rows._2), seats.cols, seats.rows._2, seats.c)
  case 'L' => Seats(seats.rows, (seats.cols._1, seats.cols._2 - ((seats.cols._2 - seats.cols._1 + 1) / 2)), seats.r, seats.cols._1)
  case 'R' => Seats(seats.rows, (seats.cols._1 + ((seats.cols._2 - seats.cols._1 + 1) / 2), seats.cols._2), seats.r, seats.cols._2)
}}

val t = tickets.map(t => fold(t).r * 8 + fold(t).c)
//Answer
t.max

//PART 2
//Answer
(t.min to t.max).toSet.diff(t.toSet)




