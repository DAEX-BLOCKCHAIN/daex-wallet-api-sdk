package io.daex.api.wallet.sdk.v1.model.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 提现/转账 实体类
 */
public class DrawEntity implements Serializable {
    private static final long serialVersionUID = 5288040167369296252L;
    /**
     * 提现地址
     */
    private String putAddress;
    /**
     * 提现金额集
     */
    private BigDecimal putAmount;
    /**
     * 外部流水号
     */
    private String externalOrderNumber;
    /**
     * 备注
     */
    private String remark;
    /**
     * memo  /提现  bts 等有值
     */
    private String memo;

    /**
     * 平台代理手续费
     */
    private BigDecimal platformFee;


    public String getPutAddress() {
        return putAddress;
    }

    public void setPutAddress(String putAddress) {
        this.putAddress = putAddress;
    }

    public BigDecimal getPutAmount() {
        return putAmount;
    }

    public void setPutAmount(BigDecimal putAmount) {
        this.putAmount = putAmount;
    }

    public String getExternalOrderNumber() {
        return externalOrderNumber;
    }

    public void setExternalOrderNumber(String externalOrderNumber) {
        this.externalOrderNumber = externalOrderNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(BigDecimal platformFee) {
        this.platformFee = platformFee;
    }
}
