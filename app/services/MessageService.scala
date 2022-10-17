package services

import models.Message

import scala.util.{Failure, Success, Try}

class MessageService {

  var currentBalance: Int = 0

  def doTheStuff(message: Message): String = {
    println(message)
    message match {
      case input if input.message.startsWith("deposit") => {
          validated(input) match {
            case Success(value) =>
              (currentBalance += value)
              s"You deposited: $value"
            case Failure(e) => s"failed, enter a number, have an exception: $e"
          }

      }
      case input if input.message.startsWith("withdraw") => {
        validated(input) match {
            case Success(value) if (value <= currentBalance) => {
              (currentBalance -= value)
              s"You have withdrawn: ${value.toString}"
            }
            case Success(_) => "failed, enter a number less than or equal to the current balance"
            case Failure(e) => s"failed, enter a number, have an exception: $e"
          }
      }
      case input if input.message.startsWith("balance") => {
        (currentBalance).toString
      }
      case input => {
       s"I didn't understand $input"
      }
    }
  }

  def validated(input: Message): Try[Int] = {
     val amount = input.message.split(" ").last
     Try(amount.toInt)
  }
}

