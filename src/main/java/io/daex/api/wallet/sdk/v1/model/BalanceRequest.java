package io.daex.api.wallet.sdk.v1.model;

import com.sun.istack.internal.NotNull;

/**
 * Created by qingyun.yu on 2018/7/13.
 */
public class BalanceRequest {
    /**
     * 用户账户
     */
    private String payAccount;

    /**
     * 资产
     */
    private String assetCode;

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }
}
