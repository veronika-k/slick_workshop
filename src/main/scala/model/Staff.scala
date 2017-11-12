package model
import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._


/**
  * Created by inoquea on 12.11.17.
  */
case class Staff(id:Option[Long], name: String, rate:Double, age:Int)

class StaffTable (tag: Tag) extends Table[Staff](tag, "staff") {
  val id = column[Option[Long]]("id", O.PrimaryKey)
  val name = column[String]("name")
  val rate = column[Double]("rate")
  val age = column[Int]("age")

  def * = (id, name, rate, age) <> (Staff.apply _ tupled, Staff.unapply)
}