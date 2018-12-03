package io.daex.api.wallet.sdk.v1.model.api.entity;


import java.io.Serializable;
import java.math.BigDecimal;


public class TransferEntity implements Serializable {
    private static final long serialVersionUID = -8945733052078200389L;
    /**
     * 收款人账户（M）
     */
    private String recipientsAccount;
    /**
     * 付款金额（M）
     */
    private BigDecimal payAmount;
    /**
     * 外部流水号（O）
     */
    private String externalOrderNumber;
    /**
     * 备注（O）
     */
    private String remark;

    public String getRecipientsAccount() {
        return recipientsAccount;
    }

    public void setRecipientsAccount(String recipientsAccount) {
        this.recipientsAccount = recipientsAccount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
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
}
