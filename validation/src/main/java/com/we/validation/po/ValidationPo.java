package com.we.validation.po;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * @Description: 属性校验主要PO 属性基础校验:非空
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/12/13 2:13 下午
 */
@Setter
@Getter
@Validated
public class ValidationPo {

    /**
     * 校验规则:用户名称必须是数字开头,数字加英文的10位的字符串
     */
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$", message = "用户名格式不正确")
    @NotBlank(message = "用户名不允许为空")
    private String userName;

    /**
     * 校验规则:密码必须是大于10位小于20位的字符串
     */
    @Pattern(regexp = "^.{10,20}$", message = "密码不正确")
    @NotBlank(message = "密码不允许为空")
    private String password;

    /**
     * 校验规则:性别必须是男/女/不方便透露
     */
    @Pattern(regexp = "/^(男|女|不方便透露)$/")
    @NotBlank(message = "姓名不允许为空")
    private String gender;

    /**
     * 校验规则:年龄必须大于20小于85
     */
    @Range(max = 85, min = 20, message = "年龄必须大于20小于85")
    private Integer age;

    /**
     * 校验规则:邮箱必须是邮箱的格式
     */
    @Email(message = "您填写的邮箱格式不对")
    @NotBlank(message = "邮箱不允许为空")
    private String email;

    /**
     * 校验规则:手机号必须为手机号格式
     */
    @Pattern(regexp = "(134[0-8]\\\\d{7})\" + " +
            "\"|(\" + \"((13([0-3]|[5-9]))\" + " +
            "\"|149\" + \"|15([0-3]|[5-9])\" + " +
            "\"|166\" + \"|17(3|[5-8])\" + \"|18[0-9]\" + " +
            "\"|19[8-9]\" + \")\" + \"\\\\d{8}\" + \")", message = "手机格式不正确")
    @NotBlank(message = "手机号不允许为空")
    private String mobile;

    /**
     * 校验规则:是否是单身校验,可以为Null,但是如果不为空就必须是False
     */
    @AssertFalse(message = "是否单身可以为空,但是如果不为空必须是否")
    private boolean singleFlag;

    /**
     * 校验规则:出生日期必须小于当前时间
     */
    @Past
//    @NotBlank(message = "出生日期不能为空")
    private Date birthday;
}
