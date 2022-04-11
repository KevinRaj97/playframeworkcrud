package controllers.api

import model.formdata.TodoForm
import model.person.Person
import model.service.PersonService
import play.api.libs.json.Json
import play.api.mvc._
import javax.inject.Inject
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ServiceController @Inject()(
                                   cc: ControllerComponents,
                                   todoService: PersonService
                                 ) extends AbstractController(cc) {

  implicit val todoFormat = Json.format[Person]

  def getAll(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    todoService.listAllItems map { items =>
      Ok(Json.toJson(items))
    }
  }

  def getById(id: String) = Action.async { implicit request: Request[AnyContent] =>
    todoService.getItem(id) map { item =>
      Ok(Json.toJson(item))
    }
  }

  def add() = Action.async { implicit request: Request[AnyContent] =>
    TodoForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        errorForm.errors.foreach(println)
        Future.successful(BadRequest("Error!"))
      },
      data => {
        val newTodoItem = Person(data.id, data.name, data.age, data.mobileNo, data.place)
        todoService.addItem(newTodoItem).map(_ => Redirect(routes.ServiceController.getAll))
      })
  }


  def update(id: String): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    TodoForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => {
        errorForm.errors.foreach(println)
        Future.successful(BadRequest("Error!"))
      },
      data => {
        val todoItem = Person(data.id, data.name, data.age, data.mobileNo, data.place)
        todoService.updateItem(todoItem).map(_ => Redirect(routes.ServiceController.getAll))
      })
  }

  def delete(id: String): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    todoService.deleteItem(id) map { res =>
      Redirect(routes.ServiceController.getAll)
    }
  }
}