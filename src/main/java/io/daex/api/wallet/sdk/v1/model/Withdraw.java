package io.daex.api.wallet.sdk.v1.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qingyun.yu on 2018/7/14.
 */
public class Withdraw {
    private String bizNumber;
    private String outNumber;
    private String status;
    private String sucTime;
    private BigDecimal usableAmt;
    private BigDecimal freezeAmt;
    private String backURL;

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

    public String getSucTime() {
        return sucTime;
    }

    public void setSucTime(String sucTime) {
        this.sucTime = sucTime;
    }

    public BigDecimal getUsableAmt() {
        return usableAmt;
    }

    public void setUsableAmt(BigDecimal usableAmt) {
        this.usableAmt = usableAmt;
    }

    public String getBackURL() {
        return backURL;
    }

    public void setBackURL(String backURL) {
        this.backURL = backURL;
    }

    public BigDecimal getFreezeAmt() {
        return freezeAmt;
    }

    public void setFreezeAmt(BigDecimal freezeAmt) {
        this.freezeAmt = freezeAmt;
    }
}
