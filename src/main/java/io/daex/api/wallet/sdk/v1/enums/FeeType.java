package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum FeeType {
    DAX(1, "DAX"),
    NON_DAX(0, "提现币种");

    private Integer type;
    private String description;

    FeeType(Integer type, String description) {
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
