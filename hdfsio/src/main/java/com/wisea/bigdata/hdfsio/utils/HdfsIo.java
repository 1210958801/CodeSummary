package com.wisea.bigdata.hdfsio.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2019-03-14 17:24
 * @Description:主要用于读取HDFS中文件的方法
 */
public class HdfsIo {

    public void getFile() throws IOException {
        //创建configuration对象
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.20.88:9000");
        FileSystem fs = FileSystem.get(conf);
        String filePath = "hdfs://192.168.20.88:9000/flume/events/19-03-14/1732/00/events_.1552555943756";
        FSDataInputStream is = fs.open(new Path(filePath));
        File file = new File("a.txt");
        OutputStream os = new FileOutputStream(file);
        byte[] buff = new byte[1024];
        int length = 0;
        while ((length = is.read(buff)) != -1) {
            os.write(buff, 0, length);
            os.flush();
        }
        os.close();
    }
}
