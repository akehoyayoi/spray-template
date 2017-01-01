package com.example.models

import spray.json._

/**
  * Created by okayayohei on 2017/01/01.
  */
case class Echo(message: String)

object Echo extends DefaultJsonProtocol {
  implicit val echoFormat = jsonFormat1(Echo.apply)
}

case class Echo2(message1: String, message2: String)

object Echo2 extends DefaultJsonProtocol {
  implicit val echo2Format = jsonFormat2(Echo2.apply)
}


