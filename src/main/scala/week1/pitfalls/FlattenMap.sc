case class CTest(v: Int)
val s = Set(Map(CTest(0) -> List(0, 3), CTest(1) -> List(0, 2)))
val possibilities = s flatMap { m =>
  val mapping = m flatMap {
    case (label, destNodes) => destNodes map (nodes => (label, nodes))
  }
  mapping
}
possibilities


val possibilities1 = s flatMap { m =>
  val mapping = m map {
    case (label, destNodes) => destNodes map (nodes => (label, nodes))
  }
  mapping.flatten
}
possibilities1
