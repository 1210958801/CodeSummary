package com.shade.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object PeopleAnalyse {

  private val localOutInputFile = "file:///Users/liangzy/testData/"

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("LogAnalyse").setMaster("local[*]")
    //创建SparkContext对象
    val sc = new SparkContext(conf)
    //假设有两个人小张和小王他们的朋友列表如下
    val xiaozhang = List("莫依琳", "苏云漓", "夏诗语", "云梦瑶", "叶璇姬", "南宫雪", "夜云阑", "纳兰樱甯", "凤华君", "小王")
    val xiaowang = List("君辰煜", "墨凌君", "风黎漠", "卫倾云", "凰邪天", "姬玄昱", "莫云南", "小张")
    val xzRDD = sc.parallelize(xiaozhang)
    val xwRDD = sc.parallelize(xiaowang)
    maybeKnowFriends(xzRDD, xwRDD)
  }

  /**
    * 分析用户可能认识的朋友
    **/
  def maybeKnowFriends(xzRDD: RDD[String], xwRDD: RDD[String]): Unit = {
    val friends = xzRDD.cartesian(xwRDD)
    friends.saveAsTextFile(localOutInputFile)
  }
}