scalacOptions ++= Seq("-unchecked", "-deprecation")
ivyLoggingLevel := UpdateLogging.Quiet
libraryDependencies += "org.scala-sbt" % "scripted-plugin" % sbtVersion.value
addSbtPlugin("com.fommil" % "sbt-sensible" % "1.1.11")

// sbt-ensime is needed for the integration tests
addSbtPlugin("org.ensime" % "sbt-ensime" % "1.12.7")

addSbtPlugin("de.heikoseeberger" % "sbt-header" % "1.5.1")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.3")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.6.1")

//Add Hoarder
addSbtPlugin("com.github.romanowski" % "hoarder" % "1.0-for-test")
