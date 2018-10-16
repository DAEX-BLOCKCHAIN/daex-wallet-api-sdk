package io.daex.api.wallet.enums;

import io.daex.api.wallet.sdk.v1.enums.TxType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by qingyun.yu on 2018/10/16.
 */
public class TxTypeTest {
    @Test
    public void testTxType() {
        Assert.assertEquals("手续费", TxType.txType(3).category("01"));
        Assert.assertEquals("资金划转", TxType.txType(3).category("02"));
        Assert.assertEquals("创建地址", TxType.txType(3).category("03"));
        Assert.assertEquals("服务费", TxType.txType(3).category("04"));
        try {
            TxType.txType(3).category("05");
        } catch (Exception e) {
            Assert.assertEquals("The version non-support this category", e.getMessage());
        }
        try {
            TxType.txType(1).category("01");
        } catch (Exception e) {
            Assert.assertEquals("The version non-support this category", e.getMessage());
        }
    }
}
