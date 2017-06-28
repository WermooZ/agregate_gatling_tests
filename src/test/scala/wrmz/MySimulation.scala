package wrmz

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.session._
import scala.concurrent.duration._
import wrmz.steps.{AddSources, GetSnapshots, _}

class MySimulation extends Simulation {

  val httpConf = http.baseURL("http://localhost:1234")

  val addSources = new AddSources(10)
  val getSnapshot = new GetSnapshots(1)
  val databaseUtil = new DatabaseUtil()

  before {
    databaseUtil.fillWithData(100000)
  }

  after {
    databaseUtil.resetDatabase()
  }

  val scn = scenario("Normal Work").exec(addSources.run, getSnapshot.run)

  setUp(scn.inject(rampUsers(2500) over(100 seconds)).protocols(httpConf)).assertions(
    global.responseTime.max.lte(1),
    global.successfulRequests.percent.gte(95)
  )

}