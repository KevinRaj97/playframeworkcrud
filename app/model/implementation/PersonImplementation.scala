package model.implementation

import model.tableconfig.PersonInformation
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._
import model.person.Person
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class PersonImplementation @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
                                    (implicit executionContext: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  val list = TableQuery[PersonInformation]


  //Adding Information
  def addInfo(info: Person): Future[String] = {
    dbConfig.db
      .run(list += info)
      .map(res => "TodoItem successfully added")
      .recover {
        case ex: Exception => {
          printf(ex.getMessage())
          ex.getMessage
        }
      }
  }

  //deleting the Information
  def delete(id: String): Future[Int] = {
    dbConfig.db.run(list.filter(_.id === id).delete)
  }

  //update the Information
  def update(updt: Person): Future[Int] = {
    dbConfig.db
      .run(list.filter(_.id === updt.id)
        .map(z => (z.name, z.age))
        .update(updt.name, updt.age)
      )
  }

  //View the data
  def get(id: String): Future[Option[Person]] = {
    dbConfig.db.run(list.filter(_.id === id).result.headOption)
  }

  //View All data
  def listAll: Future[Seq[Person]] = {
    dbConfig.db.run(list.result)
  }

}
