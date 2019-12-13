package com.test.mybatisplusdemo.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 为创建者构建数据库信息
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/11/9 10:05 上午
 */
@Setter
@Getter
public class DataSourcePo {

    /**
     * choose host
     * */
    @ApiModelProperty(value = "连接的主机")
    private String host;

    /**
     * Fully qualified name of the JDBC driver. Auto-detected based on the URL by default.
     */
    @ApiModelProperty(value = "连接器名称",hidden = true)
    private String driverName = "com.mysql.cj.jdbc.Driver";

    /**
     * JDBC URL of the database.
     */
    @ApiModelProperty(value = "连接池路径",hidden = true)
    private String url;

    /**
     * Login username of the database.
     */
    @ApiModelProperty(value = "用户名",hidden = true)
    private String username;

    /**
     * Login password of the database.
     */
    @ApiModelProperty(value = "密码",hidden = true)
    private String password;

    /**
     * parent package path
     */
    private String parent;

    /**
     * 是否生成全部表
     */
    private boolean wheAll;

    /**
     * 如果不是生成全部,则填写要生成的表名
     */
    private String[] tables;

    /**
     * 是否生成service、controller
     */
    private boolean wheSerCon;

    /**
     * 是否生成xml
     */
    private boolean wheXml;
}
