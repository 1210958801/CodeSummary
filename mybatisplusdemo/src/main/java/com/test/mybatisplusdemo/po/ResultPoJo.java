package com.test.mybatisplusdemo.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 自定义返回Pojo工具类
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2019/10/31 5:17 下午
 */
@Setter
@Getter
public class ResultPoJo<T> {

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回实体
     */
    private T result;

    public ResultPoJo(T result) {
        this.result = result;
    }

    public ResultPoJo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultPoJo() {
        this.code = ReturnCode.SUCCESS.getCode();
    }

    public static ResultPoJo create() {
        return new ResultPoJo();
    }

    /**
     * 通过抽象接口来设置
     *
     * @param errorStatus
     */
    public void setErrorStatus(ReturnCode errorStatus) {
        this.code = errorStatus.getCode();
        this.msg = errorStatus.getMsg();
    }
}
