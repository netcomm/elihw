import sbt._
import Keys._

object ElihwBuild extends Build {
  import BuildSettings._
  import Dependencies._

  val resolutionRepos = Seq(
//    "maven" at "http://repo1.maven.org/maven2/",
//    "Twitter Maven Repo" at "http://maven.twttr.com/",
//    "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
  )

  lazy val parent = Project(id = "elihw",
    base = file("."))
    .aggregate (manager, client)
    .settings(basicSettings: _*)

  lazy val manager = Project(id = "manager", base = file("manager"))
    .settings(managerSettings: _*)
    .settings(libraryDependencies ++=
    compile(akka_slf4j, akka_actor) ++
      test(scalaTest, akka_testkit))

  lazy val client = Project(id = "client", base = file("client"))
    .settings(clientSettings: _*)
    .settings(libraryDependencies ++=
      test(scalaTest))
}
