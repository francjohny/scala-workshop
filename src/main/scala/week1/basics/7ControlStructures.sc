/*----------------------------------------------*/
/*       Lesson 7 - Control Structures          */
/*----------------------------------------------*/


// 1. Looping with for and foreach
// 2. Using for loops with multiple counters
// 3. Using for loops with guards
// 4. Creating a for comprehension
// 5. Implementing break and continue
// 6. Using if as a ternary operator
// 7. Using a match expression like a switch statement
// 8. Matching multiple conditions with one case statement
// 9. Assigning the result of a match expression to a variable
// 10. Accessing the value of a default case
// 11. Using pattern matching in match expressions
import scala.util.control.Breaks
import util.control.Breaks._

object BreakAndContinueDemo extends App {
  breakable {
    for (i ← 1 to 10) {
      println(i)
      if (i > 4) break
    }
  }
}

// continue is basically using the same construct

val Inner = new Breaks
val Outer = new Breaks

Outer.breakable {
  for (i ← 1 to 5) {
    Inner.breakable {
      for (j ← 'a' to 'e') {
        if (i == 1 && j == 'c') Inner.break else println(s"i = ${i} j = ${j}")
        if (i == 2 && j == 'b') Outer.break
      }
    }
  }
}

var barrelIsFull = false
for (money ← List(1, 2, 3) if !barrelIsFull) {
  println(money)
  barrelIsFull = checkIfBarrelIsFull
}

def checkIfBarrelIsFull: Boolean = true

def sumToMax(arr: Array[Int], limit: Int): Int = {
  var sum = 0
  for (i ← arr) {
    sum += i
    if (sum > limit) return limit
  }
  sum
}

val a = Array.range(0, 10)
sumToMax(a, 10)


def factorial(n: Int): Int = {
  import scala.annotation.tailrec
  @tailrec def factorialAcc(acc: Int, n: Int): Int = {
    if (n <= 1) acc
    else factorialAcc(n * acc, n - 1)
  }
  factorialAcc(1, n)
}

factorial(5)

