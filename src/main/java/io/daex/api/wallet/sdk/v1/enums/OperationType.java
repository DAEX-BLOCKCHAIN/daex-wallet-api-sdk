package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum OperationType {
    CONFIRM("01", "确认"),
    REVOCATION("02", "撤销");

    private String type;
    private String description;

    OperationType(String type, String description) {
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
