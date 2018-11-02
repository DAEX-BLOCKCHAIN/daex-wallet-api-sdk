package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/11/2.
 */
public enum AddressGenerateMode {
    SINGLE("01", "单个"),BATCH("02", "批量");

    private String pattern;
    private String description;

    AddressGenerateMode(String pattern, String description) {
        this.pattern = pattern;
        this.description = description;
    }

    public String pattern() {
        return this.pattern;
    }

    public String description() {
        return this.description;
    }
}
