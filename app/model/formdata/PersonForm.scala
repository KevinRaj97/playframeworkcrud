package model.formdata

import play.api.data.Form
import play.api.data.Forms._


case class TodoFormData(id: String, name: String, age: String, mobileNo: Option[String], place: String)

object TodoForm {
  val form = Form(
    mapping(

      "id" -> nonEmptyText,
      "name" -> nonEmptyText,
      "age" -> nonEmptyText,
      "mobileNo" -> optional(text),
      "place" -> nonEmptyText

    )(TodoFormData.apply)(TodoFormData.unapply)
  )
}
