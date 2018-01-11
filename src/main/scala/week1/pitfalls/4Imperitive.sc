// 1. know the total amount of the items that are checks
case class Item(itemType: String, amount: Int)
val items = List(Item("ERROR", 5), Item("CHECK", 2))
val total = items.filter(_.itemType == "CHECK").map(_.amount).sum

items.foldLeft(0)((total, item) =>
  if(item.itemType == "CHECK")
    total + item.amount
  else
    total
)

(0 /: items)((total, item) ⇒
  if(item.itemType == "CHECK")
      total + item.amount
    else
      total
)

((0, 0) /: items)((total, item) ⇒
  if (item.itemType == "CHECK")
      (total._1 + 1, total._2 + item.amount)
    else
      (total._1, total._2)
)


// 2. count freq of letters in set
val input = Set(Set("a","b"),Set("b","c"))
val output = Map("b" → 2, "a" → 1, "c" → 1)
input.toSeq.flatten.groupBy(identity).mapValues(_.size)

// 3. merging maps
val mapList = List(Map("hello" -> 1.1, "world" -> 2.2), Map("goodbye" -> 3.3, "hello" -> 4.4))
mapList.reduce(_ ++ _)

class CombiningMap(m1: Map[Symbol, Double]) {
  def combine(m2: Map[Symbol, Double]): Map[Symbol, Double] = {
    val intersection: Set[Symbol] = m1.keySet.intersect(m2.keySet)
    println(intersection)
    val intersect: Set[(Symbol, Double)] = for(key <- intersection)
      yield key → (m1(key) + m2(key))
    val nonIntersect: Map[Symbol, Double] = m1.filterKeys(!intersection(_)) ++ m2.filterKeys(!intersection(_))
    nonIntersect ++ intersect
  }
}

implicit def toCombining(m: Map[Symbol, Double]): CombiningMap = new CombiningMap(m)

//mapList reduce (_ combine _) // Pimp My Library pattern

import PartialFunction._

cond("abc") { case "def" => true }
condOpt("abc") { case x if x.length == 3 => x + x }
condOpt("abc") { case x if x.length == 4 => x + x }
