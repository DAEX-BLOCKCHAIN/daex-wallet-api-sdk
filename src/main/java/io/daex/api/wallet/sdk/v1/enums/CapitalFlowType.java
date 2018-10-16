package io.daex.api.wallet.sdk.v1.enums;

import java.util.stream.Stream;

/**
 * Created by qingyun.yu on 2018/10/16.
 */
public enum CapitalFlowType {
    INCOME(1, "收入"), PAY(2, "支出");
    private final Integer type;
    private final String description;

    CapitalFlowType(final Integer type, final String description) {
        this.type = type;
        this.description = description;
    }

    public static CapitalFlowType capitalFlowType(final Integer type) {
        return Stream.of(CapitalFlowType.values()).filter(value -> type == value.type()).findFirst().get();
    }

    public Integer type() {
        return type;
    }

    public String description() {
        return description;
    }
}
