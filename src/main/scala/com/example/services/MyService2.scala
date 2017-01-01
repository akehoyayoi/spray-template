package com.example.services

import com.example.models.Echo2
import spray.http.MediaTypes._
import spray.routing._
import spray.httpx.SprayJsonSupport._

/**
  * Created by okayayohei on 2017/01/01.
  */
trait MyService2 extends HttpService {
  val my2Route =
    path("my2") {
      get {
        respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            Echo2("Hello","world")
          }
        }
      }
    }

}
