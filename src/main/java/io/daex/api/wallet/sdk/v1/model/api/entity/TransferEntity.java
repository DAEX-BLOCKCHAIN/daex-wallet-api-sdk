package io.daex.api.wallet.sdk.v1.model.api.entity;


import java.io.Serializable;
import java.math.BigDecimal;


public class TransferEntity implements Serializable {
    private static final long serialVersionUID = -8945733052078200389L;
    /**
     * 收款人账户（M）
     */
    private String receAccount;
    /**
     * 付款金额（M）
     */
    private BigDecimal payAmount;
    /**
     * 外部流水号（O）
     */
    private String outNumber;
    /**
     * 备注（O）
     */
    private String remark;

    public String getReceAccount() {
        return receAccount;
    }

    public void setReceAccount(String receAccount) {
        this.receAccount = receAccount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
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
}
