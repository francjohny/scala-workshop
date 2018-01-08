/*----------------------------------------*/
/*   Lesson 2 - Everything is an object   */
/*----------------------------------------*/

// 1. Numbers are objects
1 + 2 * 3
1.+(2).*(3)

// The parentheses around the numbers are necessary as
// Scala’s lexer uses a longest match rule for tokens
1.+(2.*(3))


// 2. Functions are objects

object Timer {
  var x = 1
  def oncePerSecond(callback: () ⇒ Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def timeFlies(): Unit = {
    def apply() {
      println(x)
      x += 1
    }
  }

  def main(args: Array[String]): Unit = {
    oncePerSecond(timeFlies)
  }
}

def incr(i: Int): Unit = { i+1 }

