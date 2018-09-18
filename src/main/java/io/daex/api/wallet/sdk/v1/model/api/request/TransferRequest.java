package io.daex.api.wallet.sdk.v1.model.api.request;



import io.daex.api.wallet.sdk.v1.model.api.entity.TransferEntity;

import java.io.Serializable;
import java.util.List;


public class TransferRequest implements Serializable {

    private static final long serialVersionUID = -8945733052078200389L;
    /**
     * 付款账户
     */
    private String account;
    /**
     * 付款模式 01.单笔 02.批量
     */
    private String payPattern;
    public static String single = "01";
    public static String batch = "02";
    /**
     * 币种缩写
     */
    private String assetCode;

    /**
     * 批量转账实体类
     */
    private List<TransferEntity> transferData;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPayPattern() {
        return payPattern;
    }

    public void setPayPattern(String payPattern) {
        this.payPattern = payPattern;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public List<TransferEntity> getTransferData() {
        return transferData;
    }

    public void setTransferData(List<TransferEntity> transferData) {
        this.transferData = transferData;
    }

}
