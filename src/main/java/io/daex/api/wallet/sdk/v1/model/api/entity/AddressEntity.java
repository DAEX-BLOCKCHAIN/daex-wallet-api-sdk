package io.daex.api.wallet.sdk.v1.model.api.entity;

import java.io.Serializable;

public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 791175005870093284L;
    /**
     * 钱包充值地址
     */
    private String address;
    /**
     * memo
     */
    private String memo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
