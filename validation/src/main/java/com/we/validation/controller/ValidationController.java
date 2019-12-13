package com.we.validation.controller;

import com.we.validation.annotation.Check;
import com.we.validation.po.UserPo;
import com.we.validation.po.ValidationPo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/12/13 2:06 下午
 */
@RestController
@RequestMapping(value = "/valid")
public class ValidationController {

    /**
     * 校验参数
     */
    @GetMapping(value = "/test")
    public String validationTest(@Validated @RequestBody ValidationPo po) {
        return po.getUserName();
    }

    /**
     * 自定义验证注解
     */
    @GetMapping(value = "/customTest")
    public String customizeValidation(@Check(contains = "Liangzy") String userName) {
        return userName;
    }

    /**
     * 定义返回异常
     */
    @GetMapping(value = "/customExce")
    public String customExce(@Validated @RequestBody UserPo po) {
        System.out.println(po);
        return "error_we_custom";
    }
}
