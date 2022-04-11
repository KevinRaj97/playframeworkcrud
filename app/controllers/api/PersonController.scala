package controllers.api

import model.person.Person
import play.api.libs.json.Json
import play.api.mvc._

import javax.inject.Inject

class PersonController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  implicit val format = Json.format[Person]

  def getDetails() = Action {
    //craeting object for Person
    val person1 = Person("1", "Ajith", "23", Option("8825773502"), "Salem")
    Ok(Json.toJson(person1))
  }


}
