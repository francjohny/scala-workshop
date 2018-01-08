import java.text.DateFormat._
import java.util.{Date, Locale}

/*----------------------------------------*/
/*     Lesson 1 - A First Example         */
/*----------------------------------------*/

object HelloWorld {
  def sayHi(): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, new Locale("hi", "IN"))
    println(df format now)
    println("Hello, world! \n Welcome to today's session.")
  }
}

HelloWorld.sayHi()
