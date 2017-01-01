package com.example.services

import com.example.models.Echo
import spray.http.MediaTypes._
import spray.routing._
import spray.httpx.SprayJsonSupport._

// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`application/json`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            Echo("Hello world")
          }
        }
      }
    }
}