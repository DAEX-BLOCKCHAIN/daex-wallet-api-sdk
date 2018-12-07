package io.daex.api.wallet.sdk.v1.model.api.response;

import java.util.List;

/**
 * Created by qingyun.yu on 2018/12/7.
 */
public class Transactions {
    private Integer totalCount;
    private List<Transaction> list;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Transaction> getList() {
        return list;
    }

    public void setList(List<Transaction> list) {
        this.list = list;
    }
}
