package com.we.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Description:
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/12/13 2:06 下午
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 指定此注解的实现，即:验证器
@Constraint(validatedBy = {})
public @interface Check {

    String message() default "We_Check:param value must contais specified value!";

    // 根据实际需求定的方法
    String contains() default "";

    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 负载
    Class<? extends Payload>[] payload() default {};
}
