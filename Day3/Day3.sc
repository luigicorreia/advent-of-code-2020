import scala.io.Source

val filename="/Users/correial/Documents/Advent of Code/2020/Day3/input.txt"

val size = io.Source.fromFile(filename).getLines().size
val map = io.Source.fromFile(filename).getLines().toList
val max_size = map(0).size

def extendMap(distance : Int) : List[String] = {
  map.map(n => n * ((size * distance) / max_size + 1))
}

case class Ride(height: Int, distance: Int, trees: Int)

def tobogganRide(d: Int, h: Int): Int = extendMap(d).zipWithIndex.foldLeft(Ride(0,0,0)) { (ride, line) =>
  if(line._2 == 0 || line._2 == ride.height)
    if(line._1(ride.distance) == '#')
      Ride(ride.height + h, ride.distance + d, ride.trees + 1)
    else
      Ride(ride.height + h, ride.distance + d, ride.trees)
  else
    Ride(ride.height, ride.distance, ride.trees)
}.trees

//Answer 1
tobogganRide(3,1)

//Answer 2
val mult = tobogganRide(3,1) * tobogganRide(1,1) * tobogganRide(5,1) * tobogganRide(7,1) * tobogganRide(1,2)





