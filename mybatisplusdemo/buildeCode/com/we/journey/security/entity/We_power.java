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
 * 系统菜单表
 * </p>
 *
 * @author WeCreater
 * @since 2019-11-10
 */
@Entity(name = "we_power")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "We_power对象" , description = "系统菜单表")
public class We_power extends BaseEntity {

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

    @ApiModelProperty(value = "菜单编号,非空" )
    @Column(nullable = false, length = 255)
    @TableField("power_code" )
    private String power_code;

    @ApiModelProperty(value = "菜单名称,非空" )
    @Column(nullable = false, length = 255)
    @TableField("power_name" )
    private String power_name;

    @ApiModelProperty(value = "菜单类型" )
    @Column( length = 4)
    @TableField("type" )
    private Integer type;

    @ApiModelProperty(value = "路径,非空" )
    @Column(nullable = false, length = 255)
    @TableField("url" )
    private String url;

    @ApiModelProperty(value = "上级id" )
    @Column( length = 100)
    @TableField("parent_id" )
    private String parent_id;


}
