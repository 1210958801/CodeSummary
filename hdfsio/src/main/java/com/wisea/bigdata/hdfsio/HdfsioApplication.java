package com.wisea.bigdata.hdfsio;

import com.wisea.bigdata.hdfsio.utils.HdfsIo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class HdfsioApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(HdfsioApplication.class, args);
        HdfsIo hdfsIo = new HdfsIo();
        hdfsIo.getFile();
    }
}
