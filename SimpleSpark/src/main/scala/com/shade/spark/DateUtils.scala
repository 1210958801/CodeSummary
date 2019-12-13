package com.shade.spark

import java.util.{Date, Locale}

import org.apache.commons.lang3.time.FastDateFormat

/**
  * @Title: DateUtils
  * @ProjectName AccessLog
  * @Description: TODO
  * @author fanyanyan
  * @date 2018/12/25 14:27
  */
/**
  * 日期时间解析工具类:
  */
class DateUtils {

  //输入文件日期时间格式
  // 18/Nov/2018:00:00:17 +0000
  val YYYYMMDDHHMM_TIME = FastDateFormat.getInstance("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH)

  //目标日期格式
  val TARGET = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")


  /**
    * 获取时间：yyyy-MM-dd HH:mm:ss
    */
  def parse(time: String) = {
    TARGET.format(new Date(getTime(time)))
  }

  /**
    * 获取输入日志时间：long类型
    *
    * time: [18/Nov/2018:00:00:17 +0000]
    */
  def getTime(time: String) = {
    try {
      YYYYMMDDHHMM_TIME.parse(time.substring(time.indexOf("[") + 1,
        time.lastIndexOf("]"))).getTime
    } catch {
      case e: Exception => {
        0l
      }
    }
  }

  def main(args: Array[String]) {
    println(parse("[18/Nov/2018:00:00:17 +0000]"))
  }

}