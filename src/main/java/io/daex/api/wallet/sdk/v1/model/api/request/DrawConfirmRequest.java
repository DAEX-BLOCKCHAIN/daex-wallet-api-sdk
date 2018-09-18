package io.daex.api.wallet.sdk.v1.model.api.request;



import io.daex.api.wallet.sdk.v1.model.api.entity.DrawConfirmEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 提现确认 实体类
 */
public class DrawConfirmRequest implements Serializable {

    private static final long serialVersionUID = 7213129220996667468L;
    /**
     * 提现账户
     */
    private String account;
    /**
     * 付款模式 01.单笔 02.批量
     */
    private String payPattern;
    public static String single = "01";
    public static String batch = "02";

    /**
     * 提现资产 (币种)
     */
    private String assetCode;
    /**
     * 通知地址
     */
    private String noticeURL;

    /**
     * 确认提现data
     */
    private List<DrawConfirmEntity> drawConfirmData;

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

    public String getNoticeURL() {
        return noticeURL;
    }

    public void setNoticeURL(String noticeURL) {
        this.noticeURL = noticeURL;
    }

    public List<DrawConfirmEntity> getDrawConfirmData() {
        return drawConfirmData;
    }

    public void setDrawConfirmData(List<DrawConfirmEntity> drawConfirmData) {
        this.drawConfirmData = drawConfirmData;
    }
}
