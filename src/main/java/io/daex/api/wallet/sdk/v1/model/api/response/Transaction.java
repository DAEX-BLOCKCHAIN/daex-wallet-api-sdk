package io.daex.api.wallet.sdk.v1.model.api.response;


import java.io.Serializable;
import java.math.BigDecimal;


public class Transaction implements Serializable {

    private static final long serialVersionUID = -3739895872642613043L;

    /**
     * 流水号
     */
    private String serialNumber;
    /**
     * 外部流水号
     */
    private String outsideSerialNumber;
    /**
     * 交易状态
     */
    private String status;
    /**
     * 交易类型
     */
    private Integer transactionType;
    /**
     * 交易完成时间
     */
    private String transactionTime;
    /**
     * 交易时间戳
     */
    private String transactionTimestamp;
    /**
     * 交易哈希
     */
    private String txHash;
    /**
     * 出账方
     */
    private String sender;
    /**
     * 入账方
     */
    private String recipients;
    /**
     * 交易资产
     */
    private String assetCode;
    /**
     * 金额
     */
    private BigDecimal assetAmt;
    /**
     * 手续费
     */
    private BigDecimal handlingFee;
    /**
     * 交易网络
     */
    private String transactionNetwork;
    /**
     * 区块哈希
     */
    private String blockHash;
    /**
     * 区块高度
     */
    private String blockHeight;
    /**
     * 区块时间戳
     */
    private String blockTime;

    private String memo;

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


    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(String transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public BigDecimal getAssetAmt() {
        return assetAmt;
    }

    public void setAssetAmt(BigDecimal assetAmt) {
        this.assetAmt = assetAmt;
    }

    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getTransactionNetwork() {
        return transactionNetwork;
    }

    public void setTransactionNetwork(String transactionNetwork) {
        this.transactionNetwork = transactionNetwork;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(String blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(String blockTime) {
        this.blockTime = blockTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
