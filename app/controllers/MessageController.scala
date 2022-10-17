package controllers

import models.Message
import play.api.libs.json.JsValue
import play.api.mvc._
import services.MessageService

import javax.inject._

@Singleton
class MessageController @Inject()(messageService: MessageService, cc: ControllerComponents) extends AbstractController(cc) {

  val printMessage: Action[JsValue] = Action(parse.json) { implicit request =>
    Ok(messageService.doTheStuff((request.body).as[Message]))
  }

}