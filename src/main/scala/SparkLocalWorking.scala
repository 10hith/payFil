package retail_db

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.scalatest.{BeforeAndAfter}
import com.holdenkarau.spark.testing.{RDDComparisons, RDDGenerator, SharedSparkContext}

/**
 * Running this on spark submit ---
 * spark-submit --class retail_db.SparkLocalWorking C:\Users\lbasavaraj\IdeaProjects\spark2demo\target\scala-2.11\spark2demo_2.11-0.1.jar "C:\Users\lbasavaraj\Downloads\sparkWorking\"
 * Tutorial - https://kaizen.itversity.com/setup-development-environment-intellij-and-scala-big-data-hadoop-and-spark/
 */



object SparkLocalWorking {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:\\hadoop")
    // sql.warehouse should be specified; importing implicits only after session is built
    val spark =
      SparkSession.builder()
        .master("local")
        .config("spark.sql.warehouse.dir", "file:///c:/tmp/spark-warehouse")
        .appName("cool")
        .getOrCreate()
    import spark.implicits._

//    val someDF = Seq(
//      (8, "bat"),
//      (64, "mouse"),
//      (-27, "horse")
//    )toDF
    // Read a csv file
    val input_df = spark.read.format("csv").load(args(0))

    // Write the output file
    input_df
      .write
      .format("csv")
      .mode("overwrite")
      .save(args(1))

  }
}