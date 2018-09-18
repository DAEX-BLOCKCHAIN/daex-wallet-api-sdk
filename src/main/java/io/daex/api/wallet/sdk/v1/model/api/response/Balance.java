package io.daex.api.wallet.sdk.v1.model.api.response;




import io.daex.api.wallet.sdk.v1.model.api.entity.AssetEntity;

import java.io.Serializable;
import java.util.List;


public class Balance implements Serializable {

    private static final long serialVersionUID = -3739895872642613043L;
    /**
     * 账号
     */
    private String account;

    /**
     * 查询时间
     */
    private String dateTime;

    /**
     * 资产数据
     */
    private List<AssetEntity> assetData;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<AssetEntity> getAssetData() {
        return assetData;
    }

    public void setAssetData(List<AssetEntity> assetData) {
        this.assetData = assetData;
    }
}
