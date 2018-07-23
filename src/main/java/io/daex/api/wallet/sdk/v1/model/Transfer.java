package io.daex.api.wallet.sdk.v1.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qingyun.yu on 2018/7/14.
 */
public class Transfer {
    private String bizNumber;
    private String outNumber;
    private String status;
    private BigDecimal accountAmount;
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

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public String getSucTime() {
        return sucTime;
    }

    public void setSucTime(String sucTime) {
        this.sucTime = sucTime;
    }
}
