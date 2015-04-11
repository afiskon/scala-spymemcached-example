name := "spymemcached-example"

version := "0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
    // "net.spy" % "spymemcached" % "2.11.6"
  ("com.amazonaws" % "elasticache-java-cluster-client" % "1.0.61.0")
    .exclude("jmock", "jmock")
    .exclude("jmock", "jmock-cglib")
    .exclude("junit", "junit")
    .exclude("junit", "junit-dep")
    .exclude("org.springframework", "spring-beans")
    .exclude("org.springframework", "spring-asm")
    .exclude("cglib", "cglib-full")
    .exclude("cglib", "cglib-nodep")
  )
