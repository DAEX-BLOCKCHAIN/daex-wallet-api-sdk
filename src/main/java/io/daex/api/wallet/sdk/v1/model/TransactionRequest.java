package io.daex.api.wallet.sdk.v1.model;

import com.sun.istack.internal.NotNull;

/**
 * Created by qingyun.yu on 2018/7/12.
 */
public class TransactionRequest {
    /**
     * 交易类型  1.充值 2.提现 3.转账
     */
    private Integer tranType;

    /**
     * 资产
     */
    private String assetCode;

    /**
     * 流水号
     */
    private String serialNumber;
    /**
     * 外部流水号
     */
    private String outsideSerialNumber;

    /**
     * 用户账户
     */
    private String payAccount;
    /**
     * 起始日期
     */
    private String startDate;
    /**
     * 截止日期
     */
    private String endDate;
    /**
     * 返回条数
     */
    private Integer limit = 10;

    public Integer getTranType() {
        return tranType;
    }

    public void setTranType(Integer tranType) {
        this.tranType = tranType;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOutsideSerialNumber() {
        return outsideSerialNumber;
    }

    public void setOutsideSerialNumber(String outsideSerialNumber) {
        this.outsideSerialNumber = outsideSerialNumber;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
