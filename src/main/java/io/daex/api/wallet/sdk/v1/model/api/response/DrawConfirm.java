package io.daex.api.wallet.sdk.v1.model.api.response;

import java.io.Serializable;

/**
 * 提现/转账  返回 实体类
 */
public class DrawConfirm implements Serializable {

    private static final long serialVersionUID = 5438697918236102015L;
    /**
     * 提现流水号（清算链交易哈希）
     */
    private String bizNumber;

    /**
     * 提现复核结果
     */
    private String status;

    /**
     * 交易完成时间
     */
    private String sucTime;

    /**
     * 交易说明
     */
    private String describe;

    public String getBizNumber() {
        return bizNumber;
    }

    public void setBizNumber(String bizNumber) {
        this.bizNumber = bizNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSucTime() {
        return sucTime;
    }

    public void setSucTime(String sucTime) {
        this.sucTime = sucTime;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
