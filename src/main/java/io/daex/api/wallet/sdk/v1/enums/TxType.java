package io.daex.api.wallet.sdk.v1.enums;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by qingyun.yu on 2018/9/17.
 */
public enum TxType {
    TOP_UP(1, "充值", null),
    WITHDRAW(2, "提现", null),
    TRANSFER(3, "转账", "01:手续费,02:资金划转,03:创建地址,04:服务费");

    private Integer type;
    private String description;
    private Map<String, String> categoryMap = new HashMap<>();

    TxType(final Integer type, final String description, final String categoryStr) {
        this.type = type;
        this.description = description;
        if(categoryStr != null) {
            String[] categorys = categoryStr.split(",");
            Stream.of(categorys).forEach(category -> {
                String[] temp = category.split(":");
                categoryMap.put(temp[0], temp[1]);
            });
        }
    }

    public static TxType txType(final Integer type) {
        return Stream.of(TxType.values()).filter(value -> value.type() == type).findFirst().get();
    }

    public Integer type() {
        return this.type;
    }

    public String description() {
        return this.description;
    }

    public String category(String category) {
        String result = categoryMap.get(category);
        if(StringUtils.isBlank(result)) {
            throw new RuntimeException("The version non-support this category");
        }
        return result;
    }
}
