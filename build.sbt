name := """play-scala-seed"""
organization := "com.qbrainx"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

libraryDependencies += guice

val mysqlConnectorVersion = "8.0.28"
val playSlickVersion = "5.0.0"
val playSlickEvalutionVersion ="5.0.0"

//Adding mysql connector
libraryDependencies += "mysql" % "mysql-connector-java" % mysqlConnectorVersion

//Adding playslick
libraryDependencies += "com.typesafe.play" %% "play-slick" % playSlickVersion

//Adding playSlickEvalution
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % playSlickEvalutionVersion
