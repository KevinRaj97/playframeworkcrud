package model.tableconfig

import model.person.Person
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.MySQLProfile.api._


class PersonInformation(tag: Tag) extends Table[Person](tag, "info") {

  def id: Rep[String] = column[String]("id")

  def name: Rep[String] = column[String]("name")

  def age: Rep[String] = column[String]("age")

  def mobileNo: Rep[Option[String]] = column[Option[String]]("mobileNo")

  def place: Rep[String] = column[String]("place")

  override def * : ProvenShape[Person] =
    (id, name, age, mobileNo, place) <> (Person.tupled, Person.unapply)
}


