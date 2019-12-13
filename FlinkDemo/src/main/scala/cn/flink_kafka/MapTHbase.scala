package cn.flink_kafka

import cn.utils.Flink2Hbase
import org.apache.flink.api.common.functions.MapFunction

 class MapTHbase extends MapFunction[String,Object]{

   override def map(t: String): Object = {

     Flink2Hbase.writeIntoHBase(t)

     return null
   }

 }
