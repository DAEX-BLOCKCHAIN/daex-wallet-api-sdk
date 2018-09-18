package io.daex.api.wallet.sdk.v1.model.api.request;



import io.daex.api.wallet.sdk.v1.model.api.entity.DrawEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 提现/转账 实体类
 */
public class DrawRequest implements Serializable {

    private static final long serialVersionUID = 2506753123023523166L;
    /**
     * 账户
     */
    private String account;
    /**
     * 付款模式 01.单笔 02.批量
     */
    private String payPattern;
    public static String single = "01";
    public static String batch = "02";

    /**
     * 资产 (币种)
     */
    private String assetCode;

    /**
     * 是否dax做为手续费
     * 0：否（提现币种）
     * 1：是（DAX）
     */
    private Integer isdax;

    /**
     * 申请提现data
     */
    private List<DrawEntity> drawData;


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

    public Integer getIsdax() {
        return isdax;
    }

    public void setIsdax(Integer isdax) {
        this.isdax = isdax;
    }

    public List<DrawEntity> getDrawData() {
        return drawData;
    }

    public void setDrawData(List<DrawEntity> drawData) {
        this.drawData = drawData;
    }
}
