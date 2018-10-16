package io.daex.api.wallet.enums;

import io.daex.api.wallet.sdk.v1.enums.CapitalFlowType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by qingyun.yu on 2018/10/16.
 */
public class CapitalFlowTypeTest {
    @Test
    public void testCapitalFlowType() {
        Assert.assertEquals("收入", CapitalFlowType.capitalFlowType(1).description());
        Assert.assertEquals("支出", CapitalFlowType.capitalFlowType(2).description());
    }
}
