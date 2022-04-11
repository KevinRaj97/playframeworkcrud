package model.service

import model.implementation.PersonImplementation
import model.person.Person

import javax.inject.Inject
import scala.concurrent.Future

class PersonService @Inject()(items: PersonImplementation) {

  def addItem(item: Person): Future[String] = {
    items.addInfo(item)
  }

  def deleteItem(id: String): Future[Int] = {
    items.delete(id)
  }

  def updateItem(item: Person): Future[Int] = {
    items.update(item)
  }

  def getItem(id: String): Future[Option[Person]] = {
    items.get(id)
  }

  def listAllItems: Future[Seq[Person]] = {
    items.listAll
  }
}
