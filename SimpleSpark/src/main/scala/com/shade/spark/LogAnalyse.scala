package com.shade.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

//TODO 待入Hbase，做可视化
object LogAnalyse {

  private[LogAnalyse] val hFile = "hdfs://192.168.20.162:9000/offLine/Nginx/nginx_little.log"

  private[LogAnalyse] val localOutInputFile = "file:///Users/liangzy/testData/"

  private[LogAnalyse] val date = "2018-10-01  "

  def main(args: Array[String]) {
    /**
      * Spark程序必须做的第一件事是创建一个SparkContext对象，它告诉Spark如何访问集群
      * 首先需要构建一个包含有关应用程序信息的SparkConf对象每个JVM只能激活一个SparkContext。
      * stop()在创建新的SparkContext之前，必须使用它。
      * 并且初始化一个RDD
      **/
    val conf = new SparkConf().setAppName("LogAnalyse").setMaster("local[*]")
    //创建SparkContext对象
    val sc = new SparkContext(conf)
    //读取文件RDD
    val textFile = sc.textFile(hFile)
    //清洗数据
    val cleanedData = cleanLog(textFile)
//    cleanedData.saveAsTextFile(localOutInputFile)
    getDayDifferentIp(date,cleanedData)
    //停止Spark上下文对象
    sc.stop()
  }

  /**
    * 日志里到底有多少条返回404的记录？
    **/
  def getLogFile404Num(textFile: RDD[String]): Unit = {
    val count = textFile.map(f = everyLast => {
      val state = everyLast.split(" ")(3)
      List(state)
    })
      .map(item => item(0))
    val endCount = count.filter(log => log.contains("404")).count()
    println(endCount)
  }

  /**
    * 访问排名前5的IP
    **/
  def topFiveVisitIp(textFile: RDD[String]): Unit = {
    //数据清洗
    val count: RDD[(String, Integer)] = textFile.map(every => {
      val each = every.split(" ")
      (each(2): String, 1: Integer)
    })
    //根据key将value累加
    val addCountByKey = count.reduceByKey((x: Integer, y: Integer) => x + y)
    //将元素换位置value放在前边用作排序，排序完成之后需要将位置换回来
    val tupleRdd: RDD[(Integer, String)] = addCountByKey.map(tuple => (tuple._2, tuple._1))
    val sortedRdd: RDD[(Integer, String)] = tupleRdd.sortByKey(false, 1)
    val endResult: RDD[(String, Integer)] = sortedRdd.map(tuple => (tuple._2, tuple._1))
    //取前5的IP
    val array: Array[(String, Integer)] = endResult.take(5)
    //循环输出
    array.foreach(x => {
      System.out.println(x)
    })
  }

  /**
    * 统计每一天单个IP返回404的记录条数，并且排序
    **/
  def getEveryDayReturnFZF(textFile: RDD[String]): Unit = {
    //数据清洗
    val count: RDD[(String, String)] = textFile.map(everyLast => {
      val every = everyLast.split(" ")
      //转化为键值对
      (every(2), every(3))
    })
    val filteredData = count.filter { case (key: String, value: String) => value.contains("200") }
    val conversion = filteredData.map(data => {
      (data._1: String, 1: Integer)
    })
    val reducedData = conversion.reduceByKey((x, y) => x + y)
    //将Ip和数字互换位置
    val tupleRdd = reducedData.map(tuple => (tuple._2, tuple._1))
    val sortedRdd = tupleRdd.sortByKey(false, 1)
    val endRdd = sortedRdd.map(tuple => "Ip:" + tuple._2 + ",的成功次数为:" + tuple._1)
    endRdd.take(5).foreach(x => println(x))
  }

  /**
    * 某一天有多少个不同的IP
    * 输入格式为：2018-10-01
    * 输出格式为：2018-10-01一共有x个不同的IP,他们分别是[]
    **/
  def getDayDifferentIp(date: String, textFile: RDD[String]): Unit = {
    //清洗数据
    val count = textFile.map(everyLast => {
      val every = everyLast.split(" ")
      (every(2), every(0))
    })
    val filteredData = count.filter { case (key: String, value: String) => value.contains(date) }
    val distinctedData: RDD[String] = filteredData.keys.distinct()
    println("给定的日期:"
      + date
      + "一共有"
      + distinctedData.count()
      + "个不同的IP,他们分别是=>"
      + distinctedData.foreach(x => {
      println(x)
    }))
  }

  /**
    * 返回200最多的5天
    **/
  def getTZZAtMostFiveDay(textFile: RDD[String]): Unit = {
    val count = textFile.map(everyLast => {
      val every = everyLast.split(" ")
      (every(0): String, every(3): String)
    }).filter { case (key: String, value: String) => value.contains("200") }
      .map(x => {
        (x._1: String, 1: Integer)
      }).reduceByKey((x, y) => x + y)
      .map(x => (x._2, x._1))
      .sortByKey(false, 1)
      .map(x => (x._2, x._1)).take(5)
    count.foreach(x => println("在" + x._1 + "返回了:" + x._2 + "次"))
  }

  /**
    * 统计每一天单个Host平均发起的请求数
    * 输出格式为：2018-10-01：这一天xxIp发起了x次请求
    * 计算逻辑:将时间与IP放在一起作为key,value为计数单位
    **/
  def everyDaySingleIpRequestNum(textFile: RDD[String]): Unit = {
    val count: RDD[(String, Integer)] = textFile.map(everyLast => {
      val every = everyLast.split(" ")
      ("在" + every(0) + "IP:" + every(2), 1: Integer)
    })
    val reducedRDD = count.reduceByKey((x, y) => x + y)
    reducedRDD.foreach(x => println(x._1 + "请求了：" + x._2 + "次"))
  }

  /**
    * 计算系统每一分钟多少的流量
    * 抽样展示：默认抽样天数为5天
    **/
  def perMinuteByte(textFile: RDD[String]): Unit = {
    val sampleDate = 5;

  }

  /**
    * 清洗日志
    **/
  def cleanLog(textFile: RDD[String]): RDD[String] = {
    //将其按照空格分割
    val cleanedData = textFile.map(f = line => {
      val everyLast = line.split(" ")
      //第一个是IP
      val ip = everyLast(0)
      //第三个加第四个就是时间
      val time = new DateUtils().parse(everyLast(3) + " " + everyLast(4))
      //第十三个是状态
      val state = everyLast(13)
      //第十四个是资源大小Byte
      val resourceSize = everyLast(14)
      //时间处理
      List(time, ip, state, resourceSize)
    })
      .map(item => item(0) + " " + item(1) + " " + item(2) + " " + item(3))
    return cleanedData
  }
}