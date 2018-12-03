package io.daex.api.wallet.sdk.v1.model.api.response;


import java.io.Serializable;


public class Transfer implements Serializable {

    private static final long serialVersionUID = 5210011969463732998L;
    /**
     * 转账流水号
     */
    private String internalOrderNumber;

    /**
     * 外部流水号
     */
    private String externalOrderNumber;

    /**
     * 交易状态
     */
    private String status;

    /**
     * 说明
     */
    private String describe;

    /**
     * 交易完成时间
     */
    private String txCompletionTime;

    public String getInternalOrderNumber() {
        return internalOrderNumber;
    }

    public void setInternalOrderNumber(String internalOrderNumber) {
        this.internalOrderNumber = internalOrderNumber;
    }

    public String getExternalOrderNumber() {
        return externalOrderNumber;
    }

    public void setExternalOrderNumber(String externalOrderNumber) {
        this.externalOrderNumber = externalOrderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getTxCompletionTime() {
        return txCompletionTime;
    }

    public void setTxCompletionTime(String txCompletionTime) {
        this.txCompletionTime = txCompletionTime;
    }
}
