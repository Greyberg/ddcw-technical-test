package models

import play.api.libs.json.{Json, OFormat}

case class Message(value: String) extends AnyVal

object Message {
  implicit val format:OFormat[Message] = Json.format[Message]
}
