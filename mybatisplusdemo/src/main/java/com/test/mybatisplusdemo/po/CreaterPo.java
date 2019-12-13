package com.test.mybatisplusdemo.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 库定制PO
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/11/10 8:27 上午
 */
@Setter
@Getter
public class CreaterPo {

    @ApiModelProperty(value = "主机名称")
    private String host;
}
