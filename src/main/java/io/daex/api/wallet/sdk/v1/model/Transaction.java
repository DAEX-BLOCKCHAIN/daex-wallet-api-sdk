package io.daex.api.wallet.sdk.v1.model;

import java.math.BigDecimal;

/**
 * Created by qingyun.yu on 2018/7/12.
 */
public class Transaction {

    /**
     * 流水号
     */
    private String serialNumber;
    /**
     * 外部流水号
     */
    private String outsideSerialNumber;
    /**
     * 交易结果
     */
    private Integer transactionResult;
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
    private String transactionHash;
    /**
     * 出账方
     */
    private String transferOut;
    /**
     * 入账方
     */
    private String transferInto;
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

    public Integer getTransactionResult() {
        return transactionResult;
    }

    public void setTransactionResult(Integer transactionResult) {
        this.transactionResult = transactionResult;
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

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public String getTransferOut() {
        return transferOut;
    }

    public void setTransferOut(String transferOut) {
        this.transferOut = transferOut;
    }

    public String getTransferInto() {
        return transferInto;
    }

    public void setTransferInto(String transferInto) {
        this.transferInto = transferInto;
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
}
