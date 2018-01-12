package week1.solutions

/**
  * Sample Input
  * 5 6 7
  * 3 6 10
  *
  * Sample Output
  * 1 1
  */

object CompareTriplets {

  def main(args: Array[String]): Unit = {
    val ints: List[Array[Int]] = io.Source.stdin.getLines().take(2).toList.map(_.split("[ ]").map(_.toInt))
    val a: Array[Int] = ints.head
    val b: Array[Int] = ints.last
    val differentScores = a.zip(b).filter(x ⇒ x._1 != x._2)
    val aliceScore = differentScores.count(x ⇒ x._1 > x._2)
    val bobScore = differentScores.length - aliceScore
    println(s"$aliceScore $bobScore")
  }
}
