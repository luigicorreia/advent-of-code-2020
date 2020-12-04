import scala.io.Source

val filename="/Users/correial/Documents/Advent of Code/2020/Day2/input.txt"

val passwords = Source.fromFile(filename).getLines.toList

val f1 = (password : String, letter: Char, bounds: Array[Int]) => {
  if(password.count(_ == letter) >= bounds(0) && password.count(_ == letter) <= bounds(1))
    true
  else false
}

val f2 = (password : String, letter: Char, bounds: Array[Int]) => {
  val code = password.charAt(bounds(0)-1) + "" +  password.charAt(bounds(1)-1)
  if(code.contains(letter) && code.count(_ == letter) == 1) true
  else false

}

def checkChars(fx: (String, Char, Array[Int]) => Boolean, pw: String): Boolean = {
  val parts = pw.split(" ")
  val bounds = parts(0).split("-").map(n => n.toInt)
  val letter = parts(1)(0)
  val password = parts(2)
  fx(password, letter, bounds)
}

//Answer 1
passwords.map(n => if(checkChars(f1, n)) 1 else 0).sum

//Answer 2
passwords.map(n => if(checkChars(f2, n)) 1 else 0).sum
