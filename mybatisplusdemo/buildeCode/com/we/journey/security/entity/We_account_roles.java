package com.we.journey.security.entity;

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
 * 系统用户角色中间表
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
@Entity(name = "we_account_roles")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "We_account_roles对象" , description = "系统用户角色中间表")
public class We_account_roles extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户表关联id,非空" )
    @Column(nullable = false, length = 100)
    @TableField("accounts_id" )
    private String accounts_id;

    @ApiModelProperty(value = "角色表关联id,非空" )
    @Column(nullable = false, length = 100)
    @TableField("roles_id" )
    private String roles_id;


}
