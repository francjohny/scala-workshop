// working
val text = "some text goes here"
val (first, rest) = text.splitAt(4)

// error
//var (first1, rest1) = ("", "")
//if (text.contains("z")) {
//  (first1, rest1) = text.splitAt(4)
//} else {
//  (first1, rest1) = text.splitAt(7)
//}
//println("first = " + first1)
//println("rest = " + rest1)


val (first2, rest2) = if (text.contains("z")) text.splitAt(4) else text.splitAt(7)

val (first3, rest3) = text.splitAt(if (text.contains("z")) 4 else 7)
