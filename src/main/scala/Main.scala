/**
  * Created by inoquea on 12.11.17.
  */
import model.{CountryTable, FilmTable, FilmToCastTable, FilmToCountryTable, FilmToGenreTable, GenreTable, StaffTable}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.duration._
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
object Main extends App{
  val db = Database.forConfig("mydb")
  Await.result(db.run(StaffTable.table.schema.create), Duration.Inf)
  Await.result(db.run(GenreTable.table.schema.create), Duration.Inf)
  Await.result(db.run(FilmTable.table.schema.create), Duration.Inf)
  Await.result(db.run(FilmToCastTable.table.schema.create), Duration.Inf)
  Await.result(db.run(FilmToGenreTable.table.schema.create), Duration.Inf)
  Await.result(db.run(FilmToCountryTable.table.schema.create), Duration.Inf)
}
