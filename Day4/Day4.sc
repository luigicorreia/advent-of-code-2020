val filename="/Users/correial/Documents/Advent of Code/2020/Day4/input.txt"
val list = Set("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
val regex = "^#([a-fA-F0-9]{6}"
val eye_colors = Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

// PT 1
def stringToID(s: String) : Set[String] = {
  val fields = s.replace("\n", " ").split(" ")
  fields.map(n => n.split(":")(0)).toSet
}

val IDs = io.Source.fromFile(filename).mkString.split("\\n\\n").toList.map(n => stringToID(n)).filter(x => x.size == 8 || x == list).size

//PT 2
def stringToID2(s: String) : Map[String,String] = {
  val fields = s.replace("\n", " ").split(" ")
  fields.map(n => (n.split(":")(0), n.split(":")(1))).toMap
}

def validate(m : Map[String, String]) : Boolean = {
  if(!(1920 to 2002 contains m("byr").toInt)) return false
  if(!(2010 to 2020 contains m("iyr").toInt)) return false
  if(!(2020 to 2030 contains m("eyr").toInt)) return false
  if(!m("hcl").matches("^#([a-fA-F0-9]{6})$")) return false
  if(!m("hgt").matches("(1[5-8][0-9]cm|19[0-3]cm)|(59in|6[0-9]in|7[0-6]in)")) return false
  if(!eye_colors.contains(m("ecl"))) return false
  if(!m("pid").matches("[0-9]{9}")) return false
  true
}

val IDs2 = io.Source.fromFile(filename).mkString.split("\\n\\n").toList.map(n => stringToID2(n)).filter(x => x.size == 8 || x.keys == list).filter(validate(_)).size