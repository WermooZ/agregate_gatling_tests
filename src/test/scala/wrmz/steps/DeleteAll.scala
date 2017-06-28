package wrmz.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import rapture.json.Json

import io.gatling.core.session._
import rapture.json._
import rapture.json.jsonBackends.jawn._
import rapture.json.formatters.compact
import scala.concurrent.duration._

class DeleteAll() {
  val run = exec(http("Delete")
    .delete("/"))
    .pause(10)
}

