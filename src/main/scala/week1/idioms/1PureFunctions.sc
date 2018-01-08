import scala.collection.mutable.ArrayBuffer

/*-----------------------------------------------------------------*/
/* Lesson 1 - Create methods with no side effects (Pure functions) */
/*-----------------------------------------------------------------*/

/**
  * A poorly written Stock class that follows the Java/OOP paradigm.
  * It not only has the ability to store information about a stock,
  * but it can also access the internet to get the current stock price,
  * and further maintains a list of historical prices for the stock.
  * @param symbol A unique series of letters assigned to a security for trading purposes.
  * @param company A business entity in which shares of the company's stock can be bought and sold by shareholders.
  * @param price A share price is the price of a single share of a number of saleable stocks of a company
  * @param volume The number of shares or contracts traded in a security or an entire market during a given period of time
  */
class Stock(var symbol: String, var company: String,
            var price: BigDecimal, var volume: Long) {
  var html: String = _
  def buildUrl(stockSymbol: String): String = { ??? }
  def getUrlContent(url: String): String = { ??? }

  def getPrice(): BigDecimal = { return this.price}
  def getVolume(): Long = { return this.volume }

  def setPrice(html: String) { this.price = ??? }
  def setVolume(html: String) { this.volume = ??? }

  // some dao-like functionality
  private val _history: ArrayBuffer[Stock] = { ??? }
  val getHistory = _history
}

// the scala approach

//case class Stock(symbol: String, company: String)
//
//case class StockInstance(symbol: String,
//                         datetime: String,
//                         price: BigDecimal,
//                         volume: Long)
//
//object StockUtils {
//  def buildUrl(stockSymbol: String): String = { ??? }
//  def getPrice(html: String): BigDecimal = { ??? }
//  def getVolume(html: String): Long = { ??? }
//}
//
//object NetworkUtils {
//  def getUrlContent(url: String): String = { ??? }
//}
//
//object DateUtils {
//  def currentDate: String = { ??? }
//  def cuurentTime: String = { ??? }
//}
//
//object StockDao {
//  def getStockInstances(symbol: String): Vector[Stock] = { ??? }
//}

//val stock = Stock("AAPL", "Apple")
//val url = StockUtils.buildUrl(stock.symbol)
//val html = NetworkUtils.getUrlContent(url)
//val price = StockUtils.getPrice(html)
//val volume = StockUtils.getVolume(html)
//val date = DateUtils.currentDate
//val stockInstance = StockInstance(stock.symbol, date, price, volume)
//StockInstance("AAPL", "Jan 8, 2017 10:00 AM", 173.44, 23660018)

// A telltale sign of a function with side effects is that its result type is Unit.
// Follow the 80/20 rule: write 80% of your program using pure functions (the "cake"),
// then create a 20% layer of other code on top of the functional base (the "icing")
// to handle the user interface, printing, database interactions, and other methods that have "side effects"
