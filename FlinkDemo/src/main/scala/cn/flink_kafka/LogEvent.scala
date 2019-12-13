package cn.flink_kafka

import org.joda.time.DateTime

import scala.collection.mutable

/**
  * Created by ml on 03/06/2019.
  * Kafka Message Bean
  */
case class LogEvent(level: String,
                    dateTime: DateTime,
                    source: String,
                    tag: String,
                    content: mutable.HashMap[String, String]
                   )
