package model

import slick.lifted.{TableQuery, Tag}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future
/**
  * Created by inoquea on 12.11.17.
  */
case class Country(id:Option[Long], title: String)

class CountryTable (tag: Tag) extends Table[Country](tag, "countries") {
  val id = column[Long]("id", O.PrimaryKey)
  val title = column[String]("title")
  def * = (id.?, title) <> (Country.apply _ tupled, Country.unapply)
}
object CountryTable {
  val table =TableQuery[CountryTable]
}

class CountryRepository(db:Database){
  val countryTableQuery: TableQuery[CountryTable] =TableQuery[CountryTable]
  def create(country: Country): Future[Country] =
    db.run(countryTableQuery returning countryTableQuery += country)
  def update (country: Country): Future[Int] =
    db.run(countryTableQuery.filter(_.id === country.id).update(country))
  def delete (countryId: Long): Future[Int] =
    db.run(countryTableQuery.filter(_.id === countryId).delete)
  def getById(countryId: Long): Future[Option[Country]] =
    db.run(countryTableQuery.filter(_.id === countryId).result.headOption)

}