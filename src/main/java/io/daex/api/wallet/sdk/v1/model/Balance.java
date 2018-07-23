package io.daex.api.wallet.sdk.v1.model;

import java.math.BigDecimal;

/**
 * Created by qingyun.yu on 2018/7/13.
 */
public class Balance {
    /**
     * 账号
     */
    private String account;
    /**
     * 数字货币资产
     */
    private String assetCode;
    /**
     * 资产数量
     */
    private BigDecimal assetAmt;
    /**
     * 冻结资产数量
     */
    private BigDecimal freezeAmt;
    /**
     * 可用资产数量
     */
    private BigDecimal usableAmt;

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public BigDecimal getAssetAmt() {
        return assetAmt;
    }

    public void setAssetAmt(BigDecimal assetAmt) {
        this.assetAmt = assetAmt;
    }

    public BigDecimal getFreezeAmt() {
        return freezeAmt;
    }

    public void setFreezeAmt(BigDecimal freezeAmt) {
        this.freezeAmt = freezeAmt;
    }

    public BigDecimal getUsableAmt() {
        return usableAmt;
    }

    public void setUsableAmt(BigDecimal usableAmt) {
        this.usableAmt = usableAmt;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
