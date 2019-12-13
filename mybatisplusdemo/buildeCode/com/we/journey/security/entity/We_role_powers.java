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
 * 系统角色菜单表
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
@Entity(name = "we_role_powers")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "We_role_powers对象" , description = "系统角色菜单表")
public class We_role_powers extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id,非空" )
    @Column(nullable = false, length = 100)
    @TableField("roles_id" )
    private String roles_id;

    @ApiModelProperty(value = "菜单id,非空" )
    @Column(nullable = false, length = 100)
    @TableField("powers_id" )
    private String powers_id;


}
