package week1.solutions

object Solution {

  def plusMinus(arr: List[Int], n: Int) =  {

    // first try
    var positive, negative, zero = 0.0
    arr.foreach {
      case x if x < 0 ⇒ negative += 1
      case x if x > 0 ⇒ positive += 1
      case _ ⇒ zero += 1
    }

    print(n, positive, negative, zero)

    // second try
    def filterNumbers(arr: List[Int]): (Double, Double, Double) =
      arr.foldLeft((0.0, 0.0, 0.0))((count, item) ⇒
        if (item > 0) (count._1 + 1, count._2, count._3)
        else if (item < 0) (count._1, count._2 + 1, count._3)
        else (count._1, count._2, count._3 + 1)
      )

    val (positivee, negativee, zeroo) = filterNumbers(arr)
    print(n, positivee, negativee, zeroo)
  }

  private def print(n: Int, positive: Double, negative: Double, zero: Double) = {
    println(f"${positive / n}%.6f")
    println(f"${negative / n}%.6f")
    println(f"${zero / n}%.6f")
  }

  def main(args: Array[String]) {
    val list: List[String] = io.Source.stdin.getLines().take(2).toList
    val n: Int = list.head.toInt
    val arr: List[Int] = list.last.split("[ ]").map(_.toInt).toList
    plusMinus(arr, n)
  }
}
