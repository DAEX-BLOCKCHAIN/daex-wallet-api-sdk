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
    private String outNumber;
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
    private BigDecimal customerInfoFees;

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

    public String getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(String outNumber) {
        this.outNumber = outNumber;
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

    public BigDecimal getCustomerInfoFees() {
        return customerInfoFees;
    }

    public void setCustomerInfoFees(BigDecimal customerInfoFees) {
        this.customerInfoFees = customerInfoFees;
    }
}
