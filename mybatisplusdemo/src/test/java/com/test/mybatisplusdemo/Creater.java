package com.test.mybatisplusdemo;

import com.test.mybatisplusdemo.util.CodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/11/8 10:18 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Creater {

    @Autowired
    private CodeGenerator codeGenerator;

    @Test
    public void test(){
        codeGenerator.init();
    }

}
