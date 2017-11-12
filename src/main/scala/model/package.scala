/**
  * Created by inoquea on 12.11.17.
  */
import scala.concurrent.duration._

import slick.jdbc.PostgresProfile.api._
package object model {
  implicit val durationTpLongMapper =
    MappedColumnType.base[Duration, Long](_.toSeconds,_.seconds)
}
