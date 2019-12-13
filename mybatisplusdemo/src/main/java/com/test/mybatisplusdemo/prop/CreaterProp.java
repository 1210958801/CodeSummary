package com.test.mybatisplusdemo.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: 生成器配置
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/11/8 9:59 上午
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "we.creater")
public class CreaterProp {

    /**
     * 父包名
     * */
    private String parent;
}
