

/*----------------------------------------------*/
/*              Lesson 6 - Strings              */
/*----------------------------------------------*/

"hello".foreach(println)

for (c ← "hello") println(c)

"scala".drop(2).take(2).capitalize
"scala".slice(2, 4).capitalize

val foo = """This is
  a multiline
string"""


val speech =
  """Four score and
    |seven years ago
  """.stripMargin


speech.replaceAll("\n", " ")

val s =
  """This is known as a
    |"multiline" string
    |or 'heredoc' syntax.
  """.stripMargin.replaceAll("\n", " ")

val csv = "eggs, milk, , ,butter, coco"

csv.split(",").map(_.trim)

csv.split("[ ]")
csv.split("\\s+")

val name = "fred"
val age = 33
val weight = 200.00

println(s"$name is $age years old, and weighs $weight pounds.")
println(f"$name is $age years old, and weighs $weight%.0f pounds.")

raw"foo\nbar"

val address = "123 Main Street Suite 101"
val numPattern = "[0-9]+".r

val matches = numPattern.findAllIn(address)
matches.foreach(println)


val p = "([0-9]+) ([A-Za-z]+)".r

val p(count, fruit) = "100 Banana"
