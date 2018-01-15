package week1.solutions

class RationalSorting {

  def insertionSort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    def insert(y: T, ys: List[T]): List[T] =
      ys match {
        case List() => y :: List()
        case z :: zs =>
          if (ord.lt(y, z)) y :: z :: zs
          else z :: insert(y, zs)
      }

    xs match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }
  }

  val nums = List(-5, 6, 3, 2, 7)
  val fruit = List("apple", "pear", "orange", "pineapple")

  insertionSort(nums)
  insertionSort(fruit)

  val compareRationals: (Rational, Rational) => Int = (x: Rational, y: Rational) ⇒ {
    if(x.denom == y.denom)  x.numer - y.numer
    else x.numer * y.denom - y.numer * x.denom
  }

  implicit val rationalOrder: Ordering[Rational] = (x: Rational, y: Rational) => compareRationals(x, y)

  val half = new Rational(1, 2)
  val third = new Rational(1, 3)
  val fourth = new Rational(1, 4)
  val rationals = List(third, half, fourth)
//  insertionSort(rationals) shouldBe List(fourth, third, half)
}

class Rational(x: Int, y: Int) {

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)

  lazy val numer: Int = x / g
  lazy val denom: Int = y / g
}
