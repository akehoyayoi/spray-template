package com.example.services

import com.example.models.Echo
import org.specs2.mutable.Specification
import spray.http.StatusCodes._
import spray.testkit.Specs2RouteTest
import spray.httpx.SprayJsonSupport._

class MyServiceSpec extends Specification with Specs2RouteTest with MyService {
  def actorRefFactory = system
  
  "MyService" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> myRoute ~> check {
        responseAs[Echo] mustEqual Echo("Hello world")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> myRoute ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put() ~> sealRoute(myRoute) ~> check {
        status === MethodNotAllowed
        responseAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
