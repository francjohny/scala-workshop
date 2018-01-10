// working
val text = "some text goes here"
val (first, rest) = text.splitAt(4)

var (first1, rest1) = ("", "")
if (text.contains("z")) {
//  (first1, rest1) = text.splitAt(4) --> error
} else {
  first1 = "abc"
  println("first1 = " + first1)
//  (first1, rest1) = text.splitAt(7) --> error
}
println("first = " + first1)
println("rest = " + rest1)

/**
  * From "4.2 Variable Declarations and Definitions":

  * Variable definitions can alternatively have a pattern (§8.1) as left-hand side.
  * A variable definition var p = e
  * where p is a pattern other than a simple name
  * or a name followed by a colon and a type is
  * expanded in the same way (§4.1) as a value definition val p = e,
  * except that the free names in p are introduced as mutable variables, not values.

  * From "6.15 Assignments":
  * The interpretation of an assignment to a simple variable
  * x = e depends on the definition of x.
  * If x denotes a mutable variable, then
  * the assignment changes the current value of x
  * to be the result of evaluating the expression e.

  * (first, rest) here is a pattern, not a simple variable,
  * so it works in the variable definition but not in the assignment.
  */

  
val (first2, rest2) = if (text.contains("z")) text.splitAt(4) else text.splitAt(7)

val (first3, rest3) = text.splitAt(if (text.contains("z")) 4 else 7)
