package com.yybm8.vo;

import lombok.Data;

@Data
public class Result<T> {
    private static final String SUCCESS = "2000";//服务器成功
    private static final String FAIL = "5000";//服务器失败
    private static final String NO_DATA = "4000";//无数据
    private static final String NO_WORK = "4002";//操作失败
    private static final String YES_WORK = "4001";//操作成功
    private static final String NO_LOGIN = "4003";//登录失败或当前未登录
    private static final String NO_REGISTER = "4004";//注册失败
    private static final String YES_LOGIN = "4005";//登录成功
    private static final String YES_REGISTER = "4006";//注册成功
    private String code;
    private String msg;
    private T data;
    public Result() {
    }
    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static Result yesWork() {
        return new Result(YES_WORK, "操作成功");
    }
    public static Result success(Object data) {
        return new Result(SUCCESS, "成功", data);
    }
    public static Result fail() {
        return new Result(FAIL, "服务器异常");
    }
    public static Result noData() {
        return new Result(NO_DATA, "无数据");
    }
    public static Result noWork() {
        return new Result(NO_WORK, "操作失败");
    }
    public static Result noLogin() {
        return new Result(NO_LOGIN, "登录失败或当前未登录");
    }
    public static Result noRegister() {
        return new Result(NO_REGISTER, "注册失败");
    }
    public static Result yesLogin() {
        return new Result(YES_LOGIN, "登录成功");
    }
    public static Result yesRegister() {
        return new Result(YES_REGISTER, "注册成功");
    }
    public static Result yesLogin(Object data) {
        return new Result(YES_LOGIN, "登录成功", data);
    }

}
