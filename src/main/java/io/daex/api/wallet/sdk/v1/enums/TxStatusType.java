package io.daex.api.wallet.sdk.v1.enums;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum TxStatusType {
    TX_COMPLETE("01", "交易完成"),
    TX_PENDING("02", "交易待处理"),
    TX_FAILED("03", "交易失败"),
    WD_CONFIRM("04", "交易撤销"),
    WD_REVOCATION("05", "交易申请待确认");

    private String status;
    private String description;

    TxStatusType(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String status() {
        return this.status;
    }

    public String description() {
        return this.description;
    }
}
