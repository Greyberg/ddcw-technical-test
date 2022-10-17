package services

import models.Message
import support.UnitSpec

class MessageServiceSpec extends UnitSpec {

  private val messageService = new MessageService

  "MessageService" - {

    "recognise deposit as a Deposit" in {

      val response = messageService.doTheStuff(Message("deposit 1000"))

      response shouldBe s"You deposited: 1000"
    }

    "recognise withdraw as a Withdrawal" in {

      val response = messageService.doTheStuff(Message("withdraw 1000"))

      response shouldBe s"You have withdrawn: 1000"
    }

    "recognise balance as a request for the balance" in {

      val response = messageService.doTheStuff(Message("balance"))

      response shouldBe s"0"
    }

    "not recognise other requests" in {

      val response = messageService.doTheStuff(Message("???"))

      response shouldBe s"I didn't understand Message(???)"
    }

  }
}
