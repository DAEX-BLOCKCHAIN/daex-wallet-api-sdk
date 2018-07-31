package io.daex.api.wallet.sdk.v1.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qingyun.yu on 2018/7/14.
 */
public class TransferRequest {

     /**
     * 付款账户 /提现
     */
    private String payAccount;

    /**
     * 付款模式 /提现
     */
    private String payPattern;

    /**
     * 付款资产 /提现
     */
    private String assetCode;

    /**
     * 收款人账户
     */
    private String receAccount;

    /**
     * 付款金额
     */
    private BigDecimal payAmount;

    /**
     * 付款时间 / 提现时间
     */
    private String payTime;

    /**
     * 是否分润
     */
    private String isShare;

    /**
     * 分润账户集
     */
    private String shareAccounts;

    /**
     * 外部流水号
     */
    private String outNumber;

    /**
     * 备注
     */
    private String remark;

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getPayPattern() {
        return payPattern;
    }

    public void setPayPattern(String payPattern) {
        this.payPattern = payPattern;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

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

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getIsShare() {
        return isShare;
    }

    public void setIsShare(String isShare) {
        this.isShare = isShare;
    }

    public String getShareAccounts() {
        return shareAccounts;
    }

    public void setShareAccounts(String shareAccounts) {
        this.shareAccounts = shareAccounts;
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
