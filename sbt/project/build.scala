import sbt._
import Keys._

object BuildSettings {
   val buildOrganization = "berkeley"
   val buildVersion = "1.1"
   val buildScalaVersion = "2.9.2"

   val buildSettings = Defaults.defaultSettings ++ Seq (
      organization := buildOrganization,
      version      := buildVersion,
      scalaVersion := buildScalaVersion//,
      //scalaSource in Compile := Path.absolute(file("../src"))
   )
}

object ChiselBuild extends Build{
   import BuildSettings._
   lazy val chisel = Project("chisel", file("chisel"), settings = buildSettings)
   lazy val gpu = Project("dreamer-apps", file("dreamer-apps"), settings = buildSettings ++ Seq(scalaSource in Compile := Path.absolute(file("../src")))) dependsOn(chisel)
}

