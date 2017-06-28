enablePlugins(GatlingPlugin)

scalaVersion := "2.11.8"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.5" % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.2.5" % "test,it"

resolvers += "justwrote" at "http://repo.justwrote.it/releases/"

libraryDependencies += "it.justwrote" %% "scala-faker" % "0.3"
libraryDependencies += "com.propensive" %% "rapture" % "2.0.0-M7"
libraryDependencies += "com.propensive" %% "rapture-json-jawn" % "1+"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.24"

