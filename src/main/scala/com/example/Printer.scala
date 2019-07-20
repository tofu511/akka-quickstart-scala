package com.example

import akka.actor.{Actor, ActorLogging, Props}

class Printer extends Actor with ActorLogging {
  import Printer._

  override def receive: Receive = {
    case Greeting(greeting) =>
      log.info(s"Greeting received (from ${sender()}): $greeting")
  }
}

object Printer {
  def props: Props = Props[Printer]
  final case class Greeting(greeting: String)
}
