package io.daex.api.wallet.sdk.v1.model.api.response;




import io.daex.api.wallet.sdk.v1.model.api.entity.AddressEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


public class WalletAddress implements Serializable {

    private static final long serialVersionUID = -3739895872642613043L;
    /**
     * 用户账号
     */
    private String account;
    /**
     * 账户余额（DAX）
     */
    private BigDecimal accountBalance;

    /**
     * 消耗的DAX数量
     */
    private BigDecimal cost;
    /**
     * 资产缩写
     */
    private String assetCode;

    /**
     * 地址数量
     */
    private Integer addressCount;

    /**
     * 地址集合
     */
    private List<AddressEntity> addressData;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

    public List<AddressEntity> getAddressData() {
        return addressData;
    }

    public void setAddressData(List<AddressEntity> addressData) {
        this.addressData = addressData;
    }
}