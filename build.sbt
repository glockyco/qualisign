name := "qualisign-scala"

version := "0.1"

scalaVersion := "2.13.1"

// -----------------------------------------------------------------------------

libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0"

// -----------------------------------------------------------------------------

// Slick

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.2"
libraryDependencies += "com.typesafe.slick" %% "slick-codegen" % "3.3.2"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2"
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.10"

// -----------------------------------------------------------------------------

// Maven Indexer
libraryDependencies += "org.eclipse.sisu" % "org.eclipse.sisu.inject" % "0.3.3"
libraryDependencies += "org.eclipse.sisu" % "org.eclipse.sisu.plexus" % "0.3.3"
libraryDependencies += "org.apache.maven.indexer" % "indexer-core" % "6.0.0"
libraryDependencies += "org.apache.maven.wagon" % "wagon-provider-api" % "2.12"
libraryDependencies += "org.apache.maven.wagon" % "wagon-http" % "2.12"

// -----------------------------------------------------------------------------

// CommandLine
libraryDependencies += "org.apache.commons" % "commons-exec" % "1.3"

// -----------------------------------------------------------------------------

// Data Transformations
libraryDependencies += "io.scalaland" %% "chimney" % "0.4.1"
