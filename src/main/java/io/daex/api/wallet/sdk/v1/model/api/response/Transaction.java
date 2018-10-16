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
     * 1.收入 2.支出
     */
    private Integer capitalFlows;
    /**
     * 交易申请时间
     */
    private String createTime;
    /**
     * 交易完成时间
     */
    private String transactionTime;

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
    private BigDecimal handlingFee;
    /**
     * 交易手续费币种
     */
    private String assetCodeFee;
    /**
     * 平台代理手续费
     */
    private BigDecimal collectionFee;
    /**
     * 交易渠道
     */
    private String channel;
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
    private String updateTime;
    /**
     * 失败原因
     */
    private String txRemark;

    /**
     * 交易时间戳(废弃)
     */
    private String transactionTimestamp;
    /**
     * 区块时间戳(废弃)
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getCapitalFlows() {
        return capitalFlows;
    }

    public void setCapitalFlows(Integer capitalFlows) {
        this.capitalFlows = capitalFlows;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
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

    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getAssetCodeFee() {
        return assetCodeFee;
    }

    public void setAssetCodeFee(String assetCodeFee) {
        this.assetCodeFee = assetCodeFee;
    }

    public BigDecimal getCollectionFee() {
        return collectionFee;
    }

    public void setCollectionFee(BigDecimal collectionFee) {
        this.collectionFee = collectionFee;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getTxRemark() {
        return txRemark;
    }

    public void setTxRemark(String txRemark) {
        this.txRemark = txRemark;
    }

    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public void setTransactionTimestamp(String transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }

    public String getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(String blockTime) {
        this.blockTime = blockTime;
    }
}
