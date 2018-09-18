package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum TxType {
    TOP_UP(1, "充值"),
    WITHDRAW(2, "提现"),
    TRANSFER(3, "转账");

    private Integer type;
    private String description;

    TxType(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public Integer type() {
        return this.type;
    }

    public String description() {
        return this.description;
    }
}
