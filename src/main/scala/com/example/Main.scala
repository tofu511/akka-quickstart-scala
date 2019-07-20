package com.example

import akka.actor.{ActorRef, ActorSystem}

object Main extends App {
  import Greeter._

  val system: ActorSystem = ActorSystem("helloAkka")

  val printer: ActorRef = system.actorOf(Printer.props, "printerActor")

  val howdyGreeter: ActorRef = system.actorOf(Greeter.props("Howdy", printer), "howdyGreeter")
  val helloGreeter: ActorRef = system.actorOf(Greeter.props("Hello", printer), "helloGreeter")
  val goodDayGreeter: ActorRef = system.actorOf(Greeter.props("Good Day", printer), "goodDayGreeter")

  howdyGreeter ! WhoToGreet("Akka")
  howdyGreeter ! Greet

  howdyGreeter ! WhoToGreet("Lightbend")
  howdyGreeter ! Greet

  helloGreeter ! WhoToGreet("Scala")
  helloGreeter ! Greet

  goodDayGreeter ! WhoToGreet("Play")
  goodDayGreeter ! Greet
}
