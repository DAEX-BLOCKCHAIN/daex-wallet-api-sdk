package io.daex.api.wallet.sdk.v1.model.api.request;


import java.io.Serializable;


public class BalanceRequest implements Serializable {

    private static final long serialVersionUID = -3739895872642613043L;
    /**
     * 用户账户(主账户有权查询子账户资产)
     */
    private String account;

    /**
     * 资产
     */
    private String assetCode;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String... assetCode) {
        StringBuilder result = new StringBuilder();
        for(String code: assetCode) {
            result.append(code).append("|");
        }
        this.assetCode = result.substring(0, result.length() - 1);
    }

}
