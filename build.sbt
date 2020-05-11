name := "hank"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "io.cucumber" %% "cucumber-scala" % "5.6.0" % Test,
  "io.cucumber" % "cucumber-jvm" % "5.6.0" % Test,
  "io.cucumber" % "cucumber-junit" % "5.6.0" % Test,
  "junit" % "junit" % "4.9" % Test,
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.10.3" % Test
)

enablePlugins(CucumberPlugin)
CucumberPlugin.glues := List("org/hank/step")
