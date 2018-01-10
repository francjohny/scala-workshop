/*----------------------------------------------*/
/* Lesson 5 - Case Classes and Pattern Matching */
/*----------------------------------------------*/

abstract class Tree
case class Sum(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree

// 1. the new keyword is not mandatory to create instances of these classes
// 2. getter functions are automatically defined for the constructor parameters
// 3. default definitions for methods equals and hashCode are provided
// 4. instances of these classes can be decomposed through pattern matching

type Environment = String => Int

def eval(t: Tree, env: Environment): Int = t match {
  case Sum(l, r) => eval(l, env) + eval(r, env)
  case Var(n)    => env(n)
  case Const(v)  => v
}

def derive(t: Tree, v: String): Tree = t match {
  case Sum(l, r) => Sum(derive(l, v), derive(r, v))
  case Var(n) if v == n => Const(1)
  case _ => Const(0)
}

def echoWhatYouGaveMe(x: Any): String = x match {

  // constant patterns
  case 0 ⇒ "Zero"
  case true ⇒ "true"
  case "hello" ⇒ "you said 'hello'"
  case Nil ⇒ "an empty List"

  // sequence patterns
  case List(0, _, _) ⇒ "a 3-element list with 0 as first element"
//  case List(1, _*) ⇒ "a list beginning with 1, having any number of elements"
  case Vector(1, _*) ⇒ "a vector starting with 1, having any number of elements"
//  case list @ List(1, _*) ⇒ s"trying to access $list"
//  case list: List[x] ⇒ s"$list"
  case 1 :: x ⇒ s"second elem of list: ${x.head}"
  case Nil ⇒ "list is empty"

  // tuples
  case (a, b) ⇒ s"got $a and $b"
  case (a, b, c) ⇒ s"got $a, $b, and $c"

  // constructor patterns
  case Person(first, "Alexander") ⇒ s"found an Alexander, first name = $first"
  case Dog("Suka") ⇒ "found a dog named Suka"

  // typed patterns
  case s: String ⇒ s"you gave me this string: $s"
  case a: Array[Int] ⇒ s"an array of int: ${a.mkString(",")}"

  // the default wildcard pattern
  case _ ⇒ "Unknown"
}

case class Person(first: String, last: String)
case class Dog(name: String)

echoWhatYouGaveMe(List(1, 2))
