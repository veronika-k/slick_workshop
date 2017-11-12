package model

import slick.lifted.{TableQuery, Tag}
import slick.jdbc.PostgresProfile.api._

/**
  * Created by inoquea on 12.11.17.
  */
case class Genre(id:Option[Long], title: String, description: Option[String])
class GenreTable (tag: Tag) extends Table[Genre](tag, "genre") {
  val id = column[Long]("id", O.PrimaryKey)
  val title = column[String]("title")
  val description = column[Option[String]]("description")

  def * = (id.?, title, description) <> (Genre.apply _ tupled, Genre.unapply)
}

object GenreTable{
  val table =TableQuery[GenreTable]
}