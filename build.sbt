version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.6"
scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

val akkaVersion = "2.5.26"
val akkaHttpVersion = "10.1.11"
val Http4sVersion = "1.0.0-M21"
libraryDependencies ++= Seq(
  // akka streams
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  // akka http
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "org.scalameta" %% "munit" % "0.7.29" % Test,
  "org.http4s" %% "http4s-dsl" % Http4sVersion,
  "org.http4s" %% "http4s-circe" % Http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
  "io.circe" %% "circe-generic" % "0.14.0-M5"
)

testFrameworks += new TestFramework("munit.Framework")
