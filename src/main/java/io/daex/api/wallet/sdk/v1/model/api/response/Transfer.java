package io.daex.api.wallet.sdk.v1.model.api.response;


import java.io.Serializable;


public class Transfer implements Serializable {

    private static final long serialVersionUID = 5210011969463732998L;
    /**
     * 转账流水号
     */
    private String bizNumber;

    /**
     * 外部流水号
     */
    private String outNumber;

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
    private String sucTime;

    public String getBizNumber() {
        return bizNumber;
    }

    public void setBizNumber(String bizNumber) {
        this.bizNumber = bizNumber;
    }

    public String getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(String outNumber) {
        this.outNumber = outNumber;
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

    public String getSucTime() {
        return sucTime;
    }

    public void setSucTime(String sucTime) {
        this.sucTime = sucTime;
    }
}
