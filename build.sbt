name := "spark2demo"

version := "0.1"

scalaVersion := "2.11.12"

//libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.4.4",
  "org.apache.spark" %% "spark-sql" % "2.4.4",
  "org.apache.spark" %% "spark-mllib" % "2.0.0",
  "org.apache.spark" %% "spark-streaming" % "2.0.0",
  "org.scalatest" %% "scalatest" % "3.2.0-M1",
  "com.holdenkarau" %% "spark-testing-base" % "2.4.3_0.12.0"
)