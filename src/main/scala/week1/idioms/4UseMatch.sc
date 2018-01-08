import java.io.{FileNotFoundException, IOException}

import scala.io.Source

/*--------------------------------------------------------------*/
/*  Lesson 4 - Use Match Expressions and Pattern Matching       */
/*--------------------------------------------------------------*/

// a) As a replacement for the Java switch statement and unwieldy if/then statements

val i = 4
val month = i match {
  case 1 ⇒ "January"
  case 2 ⇒ "February"
  case 3 ⇒ "March"
  case 4 ⇒ "April"
  case 5 ⇒ "May"
  case 6 ⇒ "June"
  case 7 ⇒ "July"
  case 8 ⇒ "August"
  case 9 ⇒ "September"
  case 10 ⇒ "October"
  case 11 ⇒ "November"
  case 12 ⇒ "December"
  case _ ⇒ "Invalid month" // the default catch-all
}


val evenOrOdd = i match {
  case 1 | 3 | 5 | 7 | 9 ⇒ println("odd")
  case 2 | 4 | 6 | 8 | 10 ⇒ println("even")
}

// b) in try/catch expressions

def readTextFile(filename: String): Option[List[String]] = {
  try {
    Some(Source.fromFile(filename).getLines().toList)
  } catch {
    case e: Exception ⇒ None
  }
}

def readTextFile2(filename: String): Option[List[String]] = {
  try {
    Some(Source.fromFile(filename).getLines().toList)
  } catch {
    case ioe: IOException ⇒
      ioe.printStackTrace()
      None
    case fnf: FileNotFoundException ⇒
      fnf.printStackTrace()
      None
  }
}

// c) as the body of a function or method

def isTrue(a: Any) = a match {
  case 0 | "" ⇒ false
  case _ ⇒ true
}

case class Dog()
case class Parrot(name: String)

def getClassAsString(x: Any): String = x match {
  case s: String ⇒ "String"
  case i: Int ⇒ "Int"
  case l: List[_] ⇒ "List"
  case Dog() ⇒ "That was a Dog"
  case Parrot(name) ⇒ s"That was a Parrot, name = $name"
  case _ ⇒ "Unknown"
}

val divide: PartialFunction[Int, Int] = {
  case d: Int if d != 0 ⇒ 42/d
}

val sample = 1 to 10
val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x+" is even"
  }

// the method collect can use isDefinedAt to select which members to collect
val evenNumbers = sample collect isEven

val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x+" is odd"
  }

// the method orElse allows chaining another partial function to handle
// input outside the declared domain
val numbers = sample map (isEven orElse isOdd)

// use with Option/Some/None
/** An Option factory which creates Some(x) if the argument is not null and None if it is null. */
def toInt(s: String): Option[Int] = {
  try {
    Some(s.toInt)
  } catch {
    case e: Exception ⇒ None
  }
}

toInt("aString") match {
  case Some(x) ⇒ println(x)
  case None ⇒ println("Error: Could not convert String to Int.")
}

// in actors

//class SarahsBrain extends Actor {
//  def receive: Unit = {
//    case StartMessage ⇒ handleStartMessage
//    case StopMessage ⇒ handleStopMessage
//    case SetMaxWaitTime(time) ⇒ helper ! SetMaxWaitTime(time)
//    case SetPhrasesToSpeak(phrases) ⇒ helper ! SetPhrasesToSpeak(phrases)
//    case _ ⇒ println("Gor something unexpected.")
//  }
//  // other code here ...
//}

/** Represents optional values. Instances of `Option`
  *  are either an instance of $some or the object $none.
  *
  *  The most idiomatic way to use an $option instance is to treat it
  *  as a collection or monad and use `map`,`flatMap`, `filter`, or
  *  `foreach`:
  */

object request {
  def getParameter(name: String): Option[String] = { Some("") }
}

val name: Option[String] = request getParameter "name"
val upper = name map { _.trim } filter { _.length != 0 } map { _.toUpperCase }
println(upper getOrElse "")

val upper1 = for {
  name <- request getParameter "name"
  trimmed <- Some(name.trim)
  upper <- Some(trimmed.toUpperCase) if trimmed.length != 0
} yield upper
println(upper getOrElse "")

/**Because of how for comprehension works, if $none is returned
from `request.getParameter`, the entire expression results in
$none

This allows for sophisticated chaining of $option values without
having to check for the existence of a value.*/

val nameMaybe = request getParameter "name"
nameMaybe match {
  case Some(name) =>
    println(name.trim.toUpperCase)
  case None =>
    println("No name value")
}

val x = List(List(1), List(3))
x.flatMap({
  case List(x) ⇒ List(x + 2)
  case _ ⇒ List()
})

val x2 = List(List(1, 2), List(3, 4))
x2.flatMap({
  case List(x, y) ⇒ List(x + y)
  case _ ⇒ List()
})

val x3 = List(Some(3), None, Some(34))
x3.flatMap({
  case Some(x) ⇒ List(x)
  case _ ⇒ List()
})
