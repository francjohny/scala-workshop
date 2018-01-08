/*----------------------------------------*/
/*     Lesson 3 - For Comprehensions      */
/*----------------------------------------*/

val c1, c2, c3 = List(1, 2, 3)

for(x <- c1; y <- c2; z <-c3) { println(x) }
c1.foreach(x => c2.foreach(y => c3.foreach(z => { println(x) })))

for(x <- c1; y <- c2; z <- c3) yield { println(x + y + z) }
c1.flatMap(x => c2.flatMap(y => c3.map(z => { println(x + y + z) })))

for(x <- c1; if x > 2) yield { println(x) }
c1.withFilter(x => x > 2).map(x => { println(x) })

for(x <- c1; y = x) yield { println(y) }
