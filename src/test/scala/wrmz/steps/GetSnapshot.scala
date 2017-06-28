package wrmz.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import rapture.json.Json

import io.gatling.core.session._
import rapture.json._
import rapture.json.jsonBackends.jawn._
import rapture.json.formatters.compact
import scala.concurrent.duration._

object GetSnaphot {
  val run = exec(http("Get Snaphot")
    .get("/snapshot"))
    .pause(1)
}

class GetSnapshots(var quantity: Int = 10) {
  val run = repeat(quantity, "i") {
      exec(GetSnaphot.run).pause(2)
  }
}

