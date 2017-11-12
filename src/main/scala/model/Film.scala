package model

import scala.concurrent.duration.Duration

/**
  * Created by inoquea on 12.11.17.
  */
case class Film(id :Option[Long], title: String, duration: Duration, directorId:Long, rating:Double) {

}
