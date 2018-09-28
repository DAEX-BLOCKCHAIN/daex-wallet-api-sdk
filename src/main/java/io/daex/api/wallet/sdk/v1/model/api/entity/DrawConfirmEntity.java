package io.daex.api.wallet.sdk.v1.model.api.entity;

import java.io.Serializable;

/**
 * 提现确认 实体类
 */
public class DrawConfirmEntity implements Serializable {

    private static final long serialVersionUID = 7213129220996667468L;
    /**
     * 提现确认验证码
     */
    private String confirmCode;

    /**
     * 提现操作类型  01.确认 02.撤销
     */
    private String operations;
    /**
     * 备注
     */
    private String remark;

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
