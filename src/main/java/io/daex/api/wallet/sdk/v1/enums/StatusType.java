package io.daex.api.wallet.sdk.v1.enums;

import java.util.stream.Stream;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum StatusType {
    S00000("成功"),
    S10001("参数不能为空"),
    S10002("参数数量错误"),
    S10003("重复请求"),
    S10004("错误的报文格式"),
    S20001("系统内部错误"),
    S20002("网络异常"),
    S30001("账户余额不足"),
    S30002("发起方账户非法（与API不匹配）"),
    S30003("账户不存在"),
    S30004("日期非法"),
    S30005("非法的账户类型"),
    S30006("地址格式错误"),
    S30007("操作金额非法（小于等于0）"),
    S30008("包含已处理的流水"),
    S30009("包含错误的提现确认验证码"),
    S30010("仅限交易平台用户使用"),
    S30011("地址库存不足"),
    S30012("提现额度不足"),
    S40001("API类型不匹配"),
    S40002("非法API"),
    S40003("API转账已关闭"),
    S40004("API提现已关闭"),
    S40005("当前币种未开放充值"),
    S40006("API已禁用"),
    S40007("回调地址错误"),
    S99999("无数据");

    private String message;

    StatusType(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }

    public static StatusType statusType(String status) {
        return Stream.of(StatusType.values()).filter(value -> ("S" + status).equals(value.name())).findFirst().get();
    }
}
