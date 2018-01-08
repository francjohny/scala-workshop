import scala.collection.mutable.ArrayBuffer

/*-----------------------------------------------------------------*/
/*              Lesson 2 - Prefer Immutable Objects                */
/*-----------------------------------------------------------------*/

/**
  * Although Scala treats methods arguments as vals,
  * you leave yourself open to the same problem by passing around a mutable collection
  * @param marks
  */
def evilMutator(marks: ArrayBuffer[Int]): Unit = {
  marks.clear() // accidents like this do happen
}

def safeMutator(marks: Vector[Int]): Unit = {
  marks.clear() // if there's no reason for others to mutate your reference / collection, don't let them do it.
}

// These approches generally seem to be used as follows:
// 1. A mutable collection field declared as a val is typically made private to its class or method
// 2. An immutable collection field declared as a var in a class is publicly visible and made available to other classes.
class Pizza {
  private val _toppings = new collection.mutable.ArrayBuffer[Topping]()

  def toppings = _toppings.toList
  def addTopping(t: Topping) { _toppings += t }
  def removeTopping(t: Topping) { _toppings -= t }

  case class Topping()
}

// Prefer vals, immutable objects and methods without side effects. Reach for them first.
