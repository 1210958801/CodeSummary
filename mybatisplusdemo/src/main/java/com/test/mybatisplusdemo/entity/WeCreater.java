package com.test.mybatisplusdemo.entity;

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
@ApiModel(value = "WeCreater对象" , description = "构建者数据库记录表")
public class WeCreater extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "连接地址,非空" )
    @Column(nullable = false, length = 30)
    @TableField("host" )
    private String host;

    @ApiModelProperty(value = "用户名称,非空" )
    @Column(nullable = false, length = 30)
    @TableField("username" )
    private String username;

    @ApiModelProperty(value = "用户密码,非空" )
    @Column(nullable = false, length = 20)
    @TableField("password" )
    private String password;


}
