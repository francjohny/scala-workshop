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