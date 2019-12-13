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
 * 系统角色表
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
@Entity(name = "we_role")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "We_role对象" , description = "系统角色表")
public class We_role extends BaseEntity {

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

    @ApiModelProperty(value = "角色编号,非空" )
    @Column(nullable = false, length = 30)
    @TableField("role_code" )
    private String role_code;

    @ApiModelProperty(value = "角色名称,非空" )
    @Column(nullable = false, length = 20)
    @TableField("role_name" )
    private String role_name;


}
