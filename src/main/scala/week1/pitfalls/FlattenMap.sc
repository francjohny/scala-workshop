import scala.collection.immutable

case class CTest(v: Int)
val s = Set(Map(CTest(0) -> List(0, 3), CTest(1) -> List(0, 2)))
val possibilities = s flatMap { m =>
  val mapping: Map[CTest, Int] = m flatMap {
    case (label, destNodes) => destNodes map (nodes => (label, nodes))
  }
  mapping
}
possibilities


val possibilities1 = s flatMap { m =>
  val mapping: immutable.Iterable[List[(CTest, Int)]] = m map {
    case (label, destNodes) => destNodes map (nodes => (label, nodes))
  }
  mapping.flatten
}
possibilities1


val l = List(1, 2, 3, 4, 5)

def f(x: Int) = if (x > 2) Some(x) else None

l.map(x => f(x)).flatten

l.flatMap(x ⇒ f(x))

def g(v:Int) = List(v-1, v, v+1)
l.map(x => g(x))
l.flatMap(x => g(x))

l.map(x => f(x))
l.flatMap(x => f(x))

val t = (1,2)
val m = Map(1 -> 2, 2 -> 4, 3 -> 6)
m.toList

m.mapValues(v => v*2)
m.mapValues(v => f(v))

m.flatMap(e => List(e._2))

def h(k:Int, v:Int) = if (v > 2) Some(k->v) else None
m.flatMap ( e => h(e._1,e._2) )

m.flatMap { case (k,v) => h(k,v) }

/*
scala> queryString
res9: scala.collection.immutable.Map[String,List[String]] = Map(a -> List(apple, aana), b -> List(banana, ball), c -> List(cat))

scala> :paste
// Entering paste mode (ctrl-D to finish)

queryString.map {
  case (k, v) =>
    if (v.length > 1) {
      v.map { x =>
        (k + "[]", x)
      }
    } else {
      List((k, v.head))
    }
}

// Exiting paste mode, now interpreting.

res10: scala.collection.immutable.Iterable[List[(String, String)]] = List(List((a[],apple), (a[],aana)), List((b[],banana), (b[],ball)), List((c,cat)))

scala> res10.toSeq
res11: Seq[List[(String, String)]] = List(List((a[],apple), (a[],aana)), List((b[],banana), (b[],ball)), List((c,cat)))

scala> res10.flatten
res6: Seq[(String, String)] = List((a[],apple), (a[],aana), (b[],banana), (b[],ball), (c,cat))

scala> :paste
// Entering paste mode (ctrl-D to finish)

queryString.flatMap {
  case (k, v) =>
    if (v.length > 1) {
      v.map { x =>
        (k + "[]", x)
      }
    } else {
      List((k, v.head))
    }
}

// Exiting paste mode, now interpreting.

res7: scala.collection.immutable.Map[String,String] = Map(a[] -> aana, b[] -> ball, c -> cat)

scala> res7.toSeq
res8: Seq[(String, String)] = Vector((a[],aana), (b[],ball), (c,cat))
*/
