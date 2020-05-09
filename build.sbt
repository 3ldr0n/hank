name := "hank"

version := "0.1"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "io.cucumber" %% "cucumber-scala" % "4.7.1" % "test",
  "io.cucumber" % "cucumber-jvm" % "4.7.1" % "test",
  "io.cucumber" % "cucumber-junit" % "4.7.1" % "test",
  "junit" % "junit" % "4.9" % "test"
)

enablePlugins(CucumberPlugin)
CucumberPlugin.glues := List("org/hank/step")
