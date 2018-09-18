package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum AccountType {
    MANAGER(1, "管理员账户"),
    MANAGER_FEE(2, "管理员手续费账户"),
    SUB_MANAGER(3, "子管理员账户");

    private Integer type;
    private String description;

    AccountType(Integer type, String  description) {
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
