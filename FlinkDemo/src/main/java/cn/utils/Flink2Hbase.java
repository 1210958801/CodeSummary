package cn.utils;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HTable;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flink2Hbase {

    private static String tableName = "t_test";
    private static String columnFamily = "lz1";
    private static String qualifer = "column-2019-06-05";

    public static void writeIntoHBase(String m)throws IOException {

        try {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            HTable table = HBaseUtils.getInstance().getTable(tableName);

            HBaseUtils.getInstance().put(tableName,df.format(new Date()),columnFamily,qualifer,m);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
