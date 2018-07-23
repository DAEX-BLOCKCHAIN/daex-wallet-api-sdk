package io.daex.api.wallet.sdk.v1.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qingyun.yu on 2018/7/12.
 */
public class WalletAddress {
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
    private List<String> addressList;

    /**
     * 可用地址数量
     */
    private Integer useAddressCount;

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

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public Integer getUseAddressCount() {
        return useAddressCount;
    }

    public void setUseAddressCount(Integer useAddressCount) {
        useAddressCount = useAddressCount;
    }
}
