/*-----------------------------------------------------------------*/
/*          Lesson 3 - Think Expression Oriented Programming       */
/*-----------------------------------------------------------------*/

/* To understand EOP, you have to understand the difference between
 * a statement and an expression. Wikipedia says:
 *
 * Statements do not return results and are executed solely for their side effects, while
 * Expressions always return a result and often do not have side effects at all.
 */

case class Stock(symbol: String, company: String)

case class StockInstance(symbol: String,
                         datetime: String,
                         price: BigDecimal,
                         volume: Long)

object StockUtils {
  def buildUrl(stockSymbol: String): String = { ??? }
  def getPrice(html: String): BigDecimal = { ??? }
  def getVolume(html: String): Long = { ??? }
}

object NetworkUtils {
  def getUrlContent(url: String): String = { ??? }
}

object DateUtils {
  def currentDate: String = { ??? }
  def cuurentTime: String = { ??? }
}

object StockDao {
  def getStockInstances(symbol: String): Vector[Stock] = { ??? }
}

//val stock = Stock("AAPL", "Apple")
//val url = StockUtils.buildUrl(stock.symbol)
//val html = NetworkUtils.getUrlContent(url)
//val price = StockUtils.getPrice(html)
//val volume = StockUtils.getVolume(html)
//val date = DateUtils.currentDate
//val stockInstance = StockInstance(stock.symbol, date, price, volume)
//StockInstance("AAPL", "Jan 8, 2017 10:00 AM", 173.44, 23660018)

List(1, 2, 3, 4, 5).filter(_ > 2)

val (a, b) = (5, 4)
val greater = if (5 > 3) println("5 is greater than 3") else b

