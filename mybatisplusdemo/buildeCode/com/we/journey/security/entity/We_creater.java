package com.we.journey.security.entity;

import java.time.LocalDateTime;
import com.test.mybatisplusdemo.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * <p>
 * 构建者数据库记录表
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
@Entity(name = "we_creater")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "We_creater对象" , description = "构建者数据库记录表")
public class We_creater extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column( length = 100)
    @TableField("create_by" )
    private String create_by;

    @Column( length = 6)
    @TableField("create_date" )
    private LocalDateTime create_date;

    @Column( length = 4)
    @TableField("del_flag" )
    private Integer del_flag;

    @Column( length = 100)
    @TableField("update_by" )
    private String update_by;

    @Column( length = 6)
    @TableField("update_date" )
    private LocalDateTime update_date;

    @ApiModelProperty(value = "连接主机,非空" )
    @Column(nullable = false, length = 30)
    @TableField("host" )
    private String host;

    @ApiModelProperty(value = "连接池路径,非空" )
    @Column(nullable = false, length = 255)
    @TableField("url" )
    private String url;

    @ApiModelProperty(value = "用户名称,非空" )
    @Column(nullable = false, length = 30)
    @TableField("username" )
    private String username;

    @ApiModelProperty(value = "用户密码,非空" )
    @Column(nullable = false, length = 20)
    @TableField("password" )
    private String password;


}
