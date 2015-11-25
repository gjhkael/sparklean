package com.ctrip.di.scala.spark;

/**
 * Created by gjh on 11/20/15.
 */
import org.apache.spark.SparkContext._
import org.apache.spark._

object ScalaWordCount {
 def main(args: Array[String]) {
    if (args.length < 1) {
      System.err.println("Usage: HdfsTest <file>")
      System.exit(1)
    }
    val sparkConf = new SparkConf().setAppName("HdfsWordCount").setMaster(args(0))
                                    .set("spark.driver.allowMultipleContexts","true")
                                   
    val sc = new SparkContext(sparkConf)

    val file = sc.textFile(args(1))       //如果是本地文件：file:///home/havstack/xxx  如果是HDFS：hdfs://slave2:9000/data/test/xxx

    //val result = file.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _).cache() //map reduce操作
    val result = file.flatMap(_.split(" ")).map(x => (x, 1)).reduceByKey(_ + _).saveAsTextFile(args(2))//map reduce操作

    /*result.foreach{x => println(x._1 + " " + x._2)}  //打印word和及其数量

    val sorted=result.map{
      
      case(key,value)=>(value,key)   //对（key，value）进行反转（value，key）
      
    }.sortByKey(true,1)          //对value进行排序

    val topk=sorted.top(10);     //取top10的word
    
    topk.foreach(println)       */ //打印

    sc.stop()                    //停止spark job
  }
}