package cn.flink_kafka

import org.apache.flink.api.common.functions.FlatMapFunction
import org.apache.flink.api.java.tuple.Tuple
import org.apache.flink.util.Collector

/**
  * Created by ml on 03/06/2019.
  *
  */
class Node extends FlatMapFunction[String,wordtuple]{

  override def flatMap(t: String, collector: Collector[wordtuple]): Unit = {

    val arr: Array[String] = t.split(",")

    collector.collect(wordtuple(arr(0),arr(1)))
  }

}

case class wordtuple(word: String,count: String)
