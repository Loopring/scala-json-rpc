import org.scalajs.sbtplugin.cross.CrossProject
import sbt.Keys._

scalaVersion in ThisBuild := "2.12.0"

val versions = new {
  val circe = "0.6.0"
  val akka = "2.5.18"
  val scalatest = "3.0.5"
  val scala = "2.12.7"
}

lazy val root = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(

    scalaVersion := versions.scala,
    bintrayOrganization := Some("flatmap"),
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    name := "jsonrpc",
    version := "0.7.0-SNAPSHOT",
    sourceDirectories in Test := Seq.empty,
    scalaVersion := versions.scala,
    scalacOptions ++= Seq("-deprecation", "-feature"),
    organization := "net.flatmap",
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core",
      "io.circe" %%% "circe-generic",
      "io.circe" %%% "circe-parser").map(_ % versions.circe),
    libraryDependencies += "org.scalatest" %%% "scalatest" % versions.scalatest % "test",
    libraryDependencies += "org.akka-js" %%% "akkajsactorstream" % "1.2.5.16",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream" % versions.akka)
