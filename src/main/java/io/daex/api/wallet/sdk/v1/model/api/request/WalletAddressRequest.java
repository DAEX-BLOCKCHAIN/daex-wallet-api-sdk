package io.daex.api.wallet.sdk.v1.model.api.request;


import java.io.Serializable;


public class WalletAddressRequest implements Serializable {

    private static final long serialVersionUID = -3739895872642613043L;
    /**
     * 付款账户
     */
    private String account;
    /**
     * 资产
     */
    private String assetCode;
    /**
     * 地址数量
     */
    private Integer addressCount = 100;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public Integer getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(Integer addressCount) {
        this.addressCount = addressCount;
    }

}
