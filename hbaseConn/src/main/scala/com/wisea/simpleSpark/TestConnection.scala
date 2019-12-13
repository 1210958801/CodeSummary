package com.wisea.simpleSpark

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.{HColumnDescriptor, HTableDescriptor, TableName}
import org.apache.hadoop.hbase.client.{ConnectionFactory, HBaseAdmin}

object TestConnection {

  /**
    * 初始化配置
    **/
  val configuration = new Configuration
  configuration.set("hbase.zookeeper.quorum", "192.168.20.162,192.168.20.180,192.168.20.193")
  configuration.set("hbase.zookeeper.property.clientPort", "2181")
  configuration.set("hbase.rootdir", "hdfs://192.168.20.162:9000/hbase")
  configuration.set("hbase.master", "192.168.20.162:16010")

//  val admin1 = new HBaseAdmin(configuration)

  val conn = ConnectionFactory.createConnection(configuration)
  val admin = conn.getAdmin()

  //创建一个hbase表
  def createTable(tableName: String, columnFamilys: Array[String]) = {
    //操作的表名
    val tName = TableName.valueOf(tableName)
    //当表不存在的时候创建Hbase表
    if (!admin.tableExists(tName)) {
      //创建Hbase表模式
      val descriptor = new HTableDescriptor(tName)
      //创建列簇i
      for (columnFamily <- columnFamilys) {
        descriptor.addFamily(new HColumnDescriptor(columnFamily))
      }
      //创建表
      admin.createTable(descriptor)
      println("create successful!!")
    }
  }

  def main(args: Array[String]): Unit = {
    createTable("test1", Array("i"))
  }
}
