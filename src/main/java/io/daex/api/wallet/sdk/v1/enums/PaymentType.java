package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/12/7.
 */
public enum PaymentType {
    BALANCE_PAY("01", "使用已有额度支付"),DAX_PAY("02", "超过额度后使用DAX支付");

    private String type;
    private String description;

    PaymentType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String type() {
        return this.type;
    }

    public String description() {
        return this.description;
    }
}
