package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum PatternType {
    SINGLE("01", "单笔"),
    MULTI("02", "批量");

    private String pattern;
    private String description;

    PatternType(String pattern, String description) {
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
