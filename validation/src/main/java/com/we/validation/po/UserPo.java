package com.we.validation.po;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Description:
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/12/13 5:22 下午
 */
@Getter
@Setter
public class UserPo {
    /**
     * 校验规则:用户名称必须是数字开头,数字加英文的10位的字符串
     */
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$", message = "用户名格式不正确")
    @NotBlank(message = "用户名不允许为空")
    private String userName;
}
