package io.daex.api.wallet.sdk.v1.enums;

import java.util.stream.Stream;

/**
 * Created by qingyun.yu on 2018/12/7.
 */
public enum FundFlow {
    INCOME(1, "收入"),PAYOUT(2, "支出");
    private Integer type;
    private String description;

    FundFlow(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public static FundFlow fundFlow(Integer type) {
        return Stream.of(FundFlow.values()).filter(value -> value.type == type).findFirst().get();
    }

    public String description() {
        return this.description;
    }
}
