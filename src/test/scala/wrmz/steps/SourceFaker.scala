package wrmz.steps

import faker.Name

case class Source(value: Int) {}

object SourceFaker {
  val feeder = Iterator.continually(
    Source(scala.util.Random.nextInt(10000) + 1)
  )
}
