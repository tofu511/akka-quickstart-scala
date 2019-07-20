package com.example

import akka.actor.{Actor, ActorRef, Props}

class Greeter(message: String, printerActor: ActorRef) extends Actor {
  import Greeter._
  import com.example.Printer.Greeting

  var greeting = ""

  override def receive: Receive = {
    case WhoToGreet(who) =>
      greeting = s"$message, $who"
    case Greet =>
      printerActor ! Greeting(greeting)
  }
}

object Greeter {
  // Propsはアクターを作成するためのオプションを指定するための設定クラス
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))
  final case class WhoToGreet(who: String)
  case object Greet
}
