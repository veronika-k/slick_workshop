/**
  * Created by inoquea on 12.11.17.
  */
import java.util.concurrent.TimeUnit

import slick.ast.BaseTypedType
import slick.jdbc.JdbcType

import scala.concurrent.duration._
import slick.jdbc.PostgresProfile.api._

package object model {
  implicit val durationToLongMapper: JdbcType[Duration] with BaseTypedType[Duration] =
    MappedColumnType.base[Duration, Long]((d:Duration)=> d.toSeconds,//(l: Long)=> l.seconds)
      (l:Long) => FiniteDuration(l, TimeUnit.SECONDS))
}
