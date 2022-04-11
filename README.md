## #CRUD operations using play Framework with Slick in Scala !!!

*This is a Simple project of Crud operations in Scala using Play framework with Slick and  MySQL database.*

## Prerequisites

* *sbt version = 1.5.5 --- [sbt](https://www.scala-sbt.org/download.html)*
* *scala version = 2.13.8 --- [scala](https://www.scala-lang.org/download/)*
* *java version=11 [java](https://www.oracle.com/java/technologies/downloads/)*
* *play framework version = 2.8.15 [play framework](https://www.playframework.com/)*

## Creating a New Project with Play

 After the Installation of [sbt](https://www.scala-sbt.org/1.x/docs/Setup.html). which gives you a proper structure for the 

 >`-> To install play and playproject`
>  `-> sbt new playframework/play-scala-seed.g8`

*After running the command and respond to the prompts to create a play project* 

>`-> name [Project Name]: play-scala-seed`
> `-> organization [org Name]: com.qbrainx`
> `-> play_version [2.8.15]: 2.8.15`
>`-> scala_version [2.13.8]: 2.13.8`

A new folder is created named `play-scala-seed` that contains the minimal project template contents.

*1.  Enter  `sbt run`  to start the server in  the system.
2.  In a browser, enter  [http://localhost:9000](http://localhost:9000/)  to view the welcome page which is a default.*


## 1 . Adding Dependencies

Here, the following dependencies for the project in *`build.sbt`*

- `libraryDependencies += "com.typesafe.play" %% "play-slick" % "5.0.0"`
- `libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0"`
- `libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.28"`

## 2 . plugins.sbt

`addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.14")`
`addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-  scaffold" % "0.13.1")`

## 3 . application.conf

`slick.dbs.default.profile = "slick.jdbc.MySQLProfile$"`  
`slick.dbs.default.db.driver = "com.mysql.cj.jdbc.Driver"`  
`slick.dbs.default.db.url = "jdbc:mysql://localhost/information"`
`slick.dbs.default.db.user ="root" `
`slick.dbs.default.db.password = "password"`

## 4 . controllers mapping

*we set the path for the routing to the CRUD operations.*

- *GET =>  getAll => [Get all items](http://localhost:9000/api/person)*
- *GET => getById/id =>[Get an item by ID](http://localhost:9000/api/person/2)*
- *POST => add => Add a new item*
- *PUT =>   update/id => Update an existing item*
- *DELETE =>delete/id =>Delete an item*

## 5 . CRUD with Postman

 Use [postman](https://www.postman.com/downloads/) for HTTP Request.

- *Create a new collection and name for the collection.*
- *Choose  the HTTP method for the request.*
- *Select the Body tab*.
- *Select the raw radio button or form data .*
- *Set the type to JSON (application/json).*
- *In the request body enter JSON for a person details.*
