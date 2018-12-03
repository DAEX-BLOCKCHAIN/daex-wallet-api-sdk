package io.daex.api.wallet.sdk.v1.model.api.response;

import java.io.Serializable;

/**
 * 提现/转账  返回 实体类
 */
public class Draw implements Serializable {

    private static final long serialVersionUID = 1142862901707818865L;
    /**
     * 提现流水号（清算链交易哈希）
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
     * 交易说明
     */
    private String describe;
    /**
     * 提现确认验证码
     */
    private String confirmCode;

    /**
     * 申请完成时间
     */
    private String txTime;

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

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public String getTxTime() {
        return txTime;
    }

    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }
}
