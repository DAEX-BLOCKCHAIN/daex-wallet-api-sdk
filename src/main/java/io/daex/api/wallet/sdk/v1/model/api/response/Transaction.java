package io.daex.api.wallet.sdk.v1.model.api.response;


import java.io.Serializable;
import java.math.BigDecimal;


public class Transaction implements Serializable {

    private static final long serialVersionUID = -3739895872642613043L;

    /**
     * 流水号
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
     * 交易类型
     */
    private Integer txType;
    /**
     * 1.收入 2.支出
     */
    private Integer fundFlow;
    /**
     * 交易申请时间
     */
    private String txTime;
    /**
     * 交易完成时间
     */
    private String txCompletionTime;

    /**
     * 交易哈希
     */
    private String txHash;
    /**
     * 出账方账户
     */
    private String senderAccount;
    /**
     * 入账方账户
     */
    private String recipientsAccount;
    /**
     * 出账方
     */
    private String sender;
    /**
     * 入账方
     */
    private String recipients;
    /**
     * memo
     */
    private String memo;
    /**
     * 交易资产
     */
    private String assetCode;
    /**
     * 金额
     */
    private BigDecimal assetAmt;
    /**
     * 交易手续费
     */
    private BigDecimal txFees;
    /**
     * 交易手续费币种
     */
    private String feeToken;
    /**
     * 平台代理手续费
     */
    private BigDecimal platformFee;
    /**
     * 交易渠道
     */
    private String channel;
    /**
     * 交易网络
     */
    private String txNetwork;
    /**
     * 区块哈希
     */
    private String blockHash;
    /**
     * 区块高度
     */
    private String blockHeight;
    /**
     * 类别 01:手续费 02:资金划转 03:创建地址 04:服务费
     */
    private String category;
    /**
     * 关联流水号
     */
    private String bindSerialNumber;
    /**
     * apiid
     */
    private String apiId;
    /**
     * 最后更新时间
     */
    private String lastUpdateTime;
    /**
     * 失败原因
     */
    private String txRemark;
    /**
     * 提现预留
     */
    private String nounce;

    public String getNounce() {
        return nounce;
    }

    public void setNounce(String nounce) {
        this.nounce = nounce;
    }

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

    public Integer getTxType() {
        return txType;
    }

    public void setTxType(Integer txType) {
        this.txType = txType;
    }

    public Integer getFundFlow() {
        return fundFlow;
    }

    public void setFundFlow(Integer fundFlow) {
        this.fundFlow = fundFlow;
    }

    public String getTxTime() {
        return txTime;
    }

    public void setTxTime(String txTime) {
        this.txTime = txTime;
    }

    public String getTxCompletionTime() {
        return txCompletionTime;
    }

    public void setTxCompletionTime(String txCompletionTime) {
        this.txCompletionTime = txCompletionTime;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getRecipientsAccount() {
        return recipientsAccount;
    }

    public void setRecipientsAccount(String recipientsAccount) {
        this.recipientsAccount = recipientsAccount;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public BigDecimal getTxFees() {
        return txFees;
    }

    public void setTxFees(BigDecimal txFees) {
        this.txFees = txFees;
    }

    public String getFeeToken() {
        return feeToken;
    }

    public void setFeeToken(String feeToken) {
        this.feeToken = feeToken;
    }

    public BigDecimal getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(BigDecimal platformFee) {
        this.platformFee = platformFee;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTxNetwork() {
        return txNetwork;
    }

    public void setTxNetwork(String txNetwork) {
        this.txNetwork = txNetwork;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBindSerialNumber() {
        return bindSerialNumber;
    }

    public void setBindSerialNumber(String bindSerialNumber) {
        this.bindSerialNumber = bindSerialNumber;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getTxRemark() {
        return txRemark;
    }

    public void setTxRemark(String txRemark) {
        this.txRemark = txRemark;
    }
}
