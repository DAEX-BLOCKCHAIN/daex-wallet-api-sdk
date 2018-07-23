package io.daex.api.wallet.sdk.v1.model;

import com.sun.istack.internal.NotNull;

/**
 * Created by qingyun.yu on 2018/7/12.
 */
public class WalletAddressRequest {
    /**
     * 付款账户
     */
    private String payAccount;

    /**
     * 地址类型
     */
    private String addressType;

    /**
     * 资产
     */
    private String assetCode;

    /**
     * 地址数量
     */
    private Integer addressCount;

    private String memo;

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public Integer getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(Integer addressCount) {
        this.addressCount = addressCount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
