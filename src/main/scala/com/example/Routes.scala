package com.example

import akka.actor.{ActorRefFactory, Actor}
import com.example.services._

/**
  * Created by okayayohei on 2017/01/01.
  */
class RoutesActor extends Actor with Routes {
  override val actorRefFactory: ActorRefFactory = context
  def receive = runRoute(routes)
}

trait Routes extends MyService with MyService2 {
  val routes = {
    myRoute ~
      my2Route
  }
}