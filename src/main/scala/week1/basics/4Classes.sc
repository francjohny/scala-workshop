/*----------------------------------------*/
/*     Lesson 4 - Classes                 */
/*----------------------------------------*/

class Complex(real: Double, imaginary: Double) {
  def re: Double = real
  def im: Double = imaginary
  override def toString() =
    "" + re + (if (im < 0) "" else "+") + im + "i"
}

object ComplexNumbers {
  def test() {
    val c = new Complex(1.2, 3.4)
    println("imaginary part: " + c.im)
  }
}

ComplexNumbers.test()
