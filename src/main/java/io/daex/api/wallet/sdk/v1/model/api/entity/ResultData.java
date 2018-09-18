package io.daex.api.wallet.sdk.v1.model.api.entity;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 791175005870093284L;
    /**
     * 付款账户
     */
    private String account;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 可用余额
     */
    private BigDecimal usableAmt;

    private List<T> backData;

    public ResultData(String account, BigDecimal totalAmount, BigDecimal usableAmt, List<T> backData) {
        this.account = account;
        this.totalAmount = totalAmount;
        this.usableAmt = usableAmt;
        this.backData = backData;
    }

    public String getAccount() {
        return account;
    }

    public void setPAccount(String account) {
        this.account = account;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getUsableAmt() {
        return usableAmt;
    }

    public void setUsableAmt(BigDecimal usableAmt) {
        this.usableAmt = usableAmt;
    }

    public List<T> getBackData() {
        return backData;
    }

    public void setBackData(List<T> backData) {
        this.backData = backData;
    }
}
