package com.test.mybatisplusdemo.po;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/10/23 10:10 上午
 */
@AllArgsConstructor
public enum ReturnCode {
    /**
     * 失败
     */
    FAIL("90000", "请求失败"),
    /**
     * 找不到用户
     */
    NOT_FOUND_USER("90001", "未查询到用户"),
    /**
     * 找不到数据
     */
    NOT_FOUND_DATA("90002", "未查询到数据"),
    /**
     * 验证码已过期或不匹配
     */
    VERIFICATION_EXPIRED_OR_MISMATCH("80000", "验证码已过期或不匹配"),
    /**
     * 用户不存在
     */
    USER_IS_NOT_EXIST("80002", "用户不存在"),

    /**
     * 成功
     */
    SUCCESS("00000", "请求成功"),

    /**
     * 登陆成功
     */
    LOGIN_SUCCESS("20000", "登陆成功"),

    /**
     * 注册成功
     */
    REGISTER_SUCCESS("10000", "注册成功");
    @Setter
    @Getter
    private String code;
    @Setter
    @Getter
    private String msg;

    /**
     * 将枚举code转成list
     */
    public static List<Map<String, Object>> toList() {
        List<Map<String, Object>> list = Lists.newArrayList();
        for (ReturnCode rc : ReturnCode.values()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", rc.getCode());
            map.put("msg", rc.getMsg());
            list.add(map);
        }
        return list;
    }
}
