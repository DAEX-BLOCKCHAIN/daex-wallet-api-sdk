package io.daex.api.wallet.sdk.v1.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qingyun.yu on 2018/7/14.
 */
public class WithdrawRequest {
    private String withdrawAccount;

    private String withdrawPattern;


    private String assetCode;

    /**
     * 付款时间 / 提现时间
     */
    private String withdrawTime;

    /**
     * 外部流水号
     */
    private String outNumber;

    /**
     * 备注
     */
    private String remark;

    /**
     * 提现地址集
     */
    private String withdrawAddress;

    /**
     * 提现金额集
     */
    private BigDecimal withdrawAmount;

    /**
     * 提现流水号
     */
    private String bizNumber;

    private String memo;

    private String operation;

    public String getWithdrawAccount() {
        return withdrawAccount;
    }

    public void setWithdrawAccount(String withdrawAccount) {
        this.withdrawAccount = withdrawAccount;
    }

    public String getWithdrawPattern() {
        return withdrawPattern;
    }

    public void setWithdrawPattern(String withdrawPattern) {
        this.withdrawPattern = withdrawPattern;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getWithdrawTime() {
        return withdrawTime;
    }

    public void setWithdrawTime(String withdrawTime) {
        this.withdrawTime = withdrawTime;
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

    public String getWithdrawAddress() {
        return withdrawAddress;
    }

    public void setWithdrawAddress(String withdrawAddress) {
        this.withdrawAddress = withdrawAddress;
    }

    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getBizNumber() {
        return bizNumber;
    }

    public void setBizNumber(String bizNumber) {
        this.bizNumber = bizNumber;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
