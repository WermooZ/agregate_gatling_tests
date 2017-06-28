package wrmz.steps

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import rapture.json.Json

import io.gatling.core.session._
import rapture.json._
import rapture.json.jsonBackends.jawn._
import rapture.json.formatters.compact
import scala.concurrent.duration._

object AddSource {
  var source = SourceFaker.feeder.next()

  val run = exec(http("Add source")
    .put("/source/" + source.value))
    .pause(1)
}

class AddSources(var quantity: Int = 10) {
  val run = repeat(quantity, "i") {
      exec(AddSource.run)
  }
}

