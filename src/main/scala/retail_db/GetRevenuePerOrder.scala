package retail_db

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._
import org.apache.spark.sql.functions._


object GetRevenuePerOrder {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\hadoop")
    val spark =
      SparkSession.builder()
        .master(args(0))
        .config("spark.sql.warehouse.dir", "file:///c:/tmp/spark-warehouse")
        .appName("cool")
        .getOrCreate()

//    val conf = new SparkConf().
//      setMaster(args(0)).
//      setAppName("Get revenue per order")
//    val spark = new SparkContext(conf)

    import spark.implicits._

    val someDF = Seq(
      (8, "bat"),
      (64, "mouse"),
      (-27, "horse")
    )toDF

//    val revenuePerOrder = orderItems.
//      map(oi => (oi.split(",")(1).toInt, oi.split(",")(4).toFloat)).
//      reduceByKey(_ + _).
//      map(oi => oi._1 + "," + oi._2)

    someDF
      .write
      .format("csv")
      .mode("overwrite")
      .save(args(2))
//    spark.sql(""" select 'hello' """)
//    spark.getConf.getAll map (println _)
  }

}