package com.ctrip.di.scala.spark;

/**
 * Created by gjh on 11/20/15.
 */
import org.apache.spark.SparkContext._
import org.apache.spark._

object ScalaSort {
 def main(args: Array[String]) {
    if (args.length < 1) {
      System.err.println("Usage: HdfsTest <file>")
      System.exit(1)
    }
    val sparkConf = new SparkConf().setAppName("HdfsTest").setMaster(args(0))
                                    .set("spark.driver.allowMultipleContexts","true")
    val sc = new SparkContext(sparkConf)
    val file = sc.textFile(args(1))       //如果是本地文件：file:///home/havstack/xxx  如果是HDFS：hdfs://slave2:9000/data/test/xxx
    val result = file.flatMap(_.split(" ")).map(x => (x.toInt, 1)).sortByKey(true,1).saveAsTextFile(args(2));
    sc.stop();
  }
}