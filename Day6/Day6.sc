val filename="/Users/correial/Documents/Advent of Code/2020/Day6/input.txt"
val questionnaires = io.Source.fromFile(filename).mkString.split("\\n\\n").toList

// Answer PT1
questionnaires.map(q => {
  q.filter(_ != '\n').distinct.size
}).sum


val q_pairs = questionnaires.map(q => (q.filter(_ != '\n'),q.split("\n").size))

//Answer PT2
q_pairs.map(
  q => q._1.filter(
    x => q._1.count(_ == x) == q._2
  ).distinct.size
).sum

