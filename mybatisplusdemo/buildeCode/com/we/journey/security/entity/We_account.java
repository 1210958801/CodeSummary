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
 * 系统用户表
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
@Entity(name = "we_account")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "We_account对象" , description = "系统用户表")
public class We_account extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建者" )
    @Column( length = 100)
    @TableField("create_by" )
    private String create_by;

    @ApiModelProperty(value = "创建时间" )
    @Column( length = 6)
    @TableField("create_date" )
    private LocalDateTime create_date;

    @ApiModelProperty(value = "删除标识" )
    @Column( length = 4)
    @TableField("del_flag" )
    private Integer del_flag;

    @ApiModelProperty(value = "修改者" )
    @Column( length = 100)
    @TableField("update_by" )
    private String update_by;

    @ApiModelProperty(value = "修改时间" )
    @Column( length = 6)
    @TableField("update_date" )
    private LocalDateTime update_date;

    @ApiModelProperty(value = "头像" )
    @Column( length = 150)
    @TableField("avatar" )
    private String avatar;

    @ApiModelProperty(value = "生日" )
    @Column( length = 6)
    @TableField("birthday" )
    private LocalDateTime birthday;

    @ApiModelProperty(value = "邮箱" )
    @Column( length = 50)
    @TableField("email" )
    private String email;

    @ApiModelProperty(value = "性别" )
    @Column( length = 4)
    @TableField("gender" )
    private Integer gender;

    @ApiModelProperty(value = "手机号" )
    @Column( length = 15)
    @TableField("mobile" )
    private String mobile;

    @ApiModelProperty(value = "昵称,非空" )
    @Column(nullable = false, length = 50)
    @TableField("nickname" )
    private String nickname;

    @ApiModelProperty(value = "密码" )
    @Column( length = 255)
    @TableField("password" )
    private String password;

    @ApiModelProperty(value = "状态,非空" )
    @Column(nullable = false, length = 4)
    @TableField("status" )
    private Integer status;

    @ApiModelProperty(value = "用户账号,非空" )
    @Column(nullable = false, length = 80)
    @TableField("username" )
    private String username;

    @ApiModelProperty(value = "用户姓名" )
    @Column( length = 20)
    @TableField("realname" )
    private String realname;


}
