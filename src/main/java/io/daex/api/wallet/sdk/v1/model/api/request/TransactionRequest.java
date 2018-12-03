package io.daex.api.wallet.sdk.v1.model.api.request;


import java.io.Serializable;


public class TransactionRequest implements Serializable {

    private static final long serialVersionUID = -3739895872642613043L;

    /**
     * 交易类型  01.充值 02.提现 03.转账
     */
    private Integer txType;
    /**
     * 资产
     */
    private String assetCode;
    /**
     * 流水号
     */
    private String internalOrderNumber;
    /**
     * 用户账户
     */
    private String account;
    /**
     * 账户类型
     * 1：管理员账户
     * 2：管理员手续费账户
     */
    private Integer accountType;
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

    public Integer getTxType() {
        return txType;
    }

    public void setTxType(Integer txType) {
        this.txType = txType;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getInternalOrderNumber() {
        return internalOrderNumber;
    }

    public void setInternalOrderNumber(String internalOrderNumber) {
        this.internalOrderNumber = internalOrderNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
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
