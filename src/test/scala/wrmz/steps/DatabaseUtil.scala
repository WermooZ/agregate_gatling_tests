package wrmz.steps

import rapture.json.Json
import rapture.json.jsonBackends.jawn._
import rapture.json.formatters.compact
import java.sql.{Connection,DriverManager}
import scala.collection.mutable.ArrayBuffer


class DatabaseUtil() {

  // connect to the database named "mysql" on port 8889 of localhost
  val url = "jdbc:mysql://172.17.0.2/agregated_stats"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "root"

  def fillWithData(userQuantity: Int = 250) {
    val feeder = SourceFaker.feeder

    var sourceValues = ArrayBuffer[Int]()
    for (i <- 1 to userQuantity) {
      var source = feeder.next()
      sourceValues += source.value
    }

    Class.forName(driver)
    var connection:Connection = DriverManager.getConnection(url, username, password)
    try {
      val statement = connection.createStatement
      val update = "INSERT INTO source (value) VALUES (" + sourceValues.mkString("), (") + ");"
      val rs = statement.executeUpdate(update);
    } catch {
      case e: Exception => e.printStackTrace
    }
    connection.close
  }

  def resetDatabase() {
    Class.forName(driver)
    var connection:Connection = DriverManager.getConnection(url, username, password)

    try {
      val statement = connection.createStatement
      statement.executeUpdate("DELETE FROM source");
      statement.executeUpdate("DELETE FROM agregated");
    } catch {
      case e: Exception => e.printStackTrace
    }
    connection.close
  }
}