import scala.util.{Failure, Success, Try}

/*-------------------------------------------------*/
/* Lesson 5 - Eliminate null values from your code */
/*-------------------------------------------------*/

/**
  * Tony Hoare, inventor of the null reference way back in 1965,
  * refers to the creation of the null value as his "billion dollar mistake".
  */

// Ban null from any of your code. Period.


// 1. Initialize var fields with Option, not null

case class Address(city: String, state: String, zip: String)

class User(email: String, password: String) {
  var firstName: String = _
  var lastName: String = _
  var address: Address = _
}

// better approach

case class Addresss(city: String, state: String, zip: String)

class Userr(email: String, password: String) {
  var firstName: Option[String] = None
  var lastName: Option[String] = None
  var address: Option[Address] = None
}

val u = new Userr("abc@xyz.com", "secret")

u.firstName = Some("abd")
u.lastName = Some("da")
u.address = Some(Address("TVM", "KL", "695010"))

println(u.firstName.getOrElse(""))

u.address.foreach {
  a ⇒ println(s"${a.city}, ${a.state}, ${a.zip}")
}

// Don't return null from methods

object Test extends App {
  def readTextFile(filename: String): Try[List[String]] = {
    Try(io.Source.fromFile(filename).getLines().toList)
  }

  val filename = "/etc/passwd"

  readTextFile(filename) match {
    case Success(lines) ⇒ lines.foreach(println)
    case Failure(f) ⇒ println(f)
  }
}

// Converting a null into an option, or something else

def getName: Option[String] = {
  var name = ???
  if (name == null) None else Some(name) // Option(name)
}

