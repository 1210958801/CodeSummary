package cn.flink_kafka

import java.util.Properties

import cn.utils.Flink2Hbase
import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.environment.CheckpointConfig.ExternalizedCheckpointCleanup
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer08

/**
  * Created by zd on 04/06/2019.
  * KafkaConsumer To Flink
  */
object KafkaConsumerToFlink {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime)

    /* Checkpoint */
    env.enableCheckpointing(60000L)
    val checkpointConf = env.getCheckpointConfig
    checkpointConf.setMinPauseBetweenCheckpoints(30000L)
    checkpointConf.setCheckpointTimeout(8000L)
    checkpointConf.enableExternalizedCheckpoints(ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION)


    /* Kafka consumer */
    val consumerProps = new Properties()
    consumerProps.setProperty("bootstrap.servers", "spark01:9092,spark02:9092")
    consumerProps.setProperty("zookeeper.connect", "spark01:2181,spark02:2181")
    consumerProps.setProperty("group.id", "test")

    val consumer: FlinkKafkaConsumer08[String] = new FlinkKafkaConsumer08(
      args(0),
      new SimpleStringSchema(),
      consumerProps
    )

    import org.apache.flink.api.scala._
    //implicit val typeInfo1 = TypeInformation.of(classOf[(String)])

    val res1: DataStream[String] = env.addSource(consumer)

    //res1.flatMap(new Node()).print().setParallelism(1)

    //implicit val typeInfo2 = TypeInformation.of(classOf[(wordtuple)])

    res1.flatMap(new Node()).keyBy("word")
      .timeWindow(Time.seconds(5),Time.seconds(5))
      .reduce((a,b) => {
          wordtuple(a.word,a.count+"---"+b.count)
        })
      .map(wordtuple => {
          wordtuple.word+"==="+wordtuple.count
      })
      .map(new MapFunction[String,Object] {
        override def map(t: String): Object = {
          Flink2Hbase.writeIntoHBase(t)
          return null
        }
      })


    env.execute("Kafka2Flink")


  }

}
