package io.daex.api.wallet.sdk.v1.model.api.request;


import java.io.Serializable;


public class WithdrawRequest implements Serializable {

    private static final long serialVersionUID = -8945733052078200389L;
    /**
     * 交易哈希
     */
    private String hash;
    /**
     * 提现订单id
     */
    private String id;
    /**
     * 币种缩写
     */
    private String assetCode;

    /**
     * 是否是平台机构用户
     */
    private Boolean platform;

    /**
     * 是否是后台过来的请求
     */
    private boolean backstage;


    public WithdrawRequest(String hash, String id, String assetCode, boolean backstage) {
        this.hash = hash;
        this.id = id;
        this.assetCode = assetCode;
        this.backstage = backstage;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public Boolean getPlatform() {
        return platform;
    }

    public void setPlatform(Boolean platform) {
        this.platform = platform;
    }

    public boolean getBackstage() {
        return backstage;
    }

    public void setBackstage(boolean backstage) {
        this.backstage = backstage;
    }
}
