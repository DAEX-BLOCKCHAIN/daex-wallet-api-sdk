package io.daex.api.wallet;

import io.daex.api.wallet.sdk.v1.DaexWalletApiClient;
import io.daex.api.wallet.sdk.v1.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by qingyun.yu on 2018/7/13.
 */
public class DaexWalletApiTest {
    private final static String endPoint = "http://www.daex.test/api";
    private final DaexWalletApiClient client = new DaexWalletApiClient(endPoint);

    @Test
    public void testCreate() {
        WalletAddressRequest walletAddressRequest = new WalletAddressRequest();
        walletAddressRequest.setAddressCount(5);
        walletAddressRequest.setAddressType("1");
        walletAddressRequest.setAssetCode("DAX");
        walletAddressRequest.setPayAccount("yuqingyun@daex.io");
        BaseResponse.WalletAddressResponse walletAddressResponse = client.walletAddress(walletAddressRequest).execute();
        System.out.println(walletAddressResponse.getMessage());
    }

    @Test
    public void testBalanceStatistical() {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setPayAccount("zhaochen@daex.io");
        balanceRequest.setAssetCode("DAX,BTC,eth");
        BaseResponse.BalancesResponse balancesResponse = client.balanceStatistical(balanceRequest).execute();
        System.out.println(balancesResponse.getMessage());
    }

    @Test
    public void testTransaction() {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAssetCode("DAX");
        transactionRequest.setSerialNumber("20180102123454G79D");
        transactionRequest.setTranType(3);
        BaseResponse.TransactionResponse transactionResponse = client.transaction(transactionRequest).execute();
        System.out.println(transactionResponse.getMessage());
    }

    @Test
    public void testTransactions() {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setPayAccount("zhaochen@daex.io");
        BaseResponse.TransactionsResponse transactionsResponse = client.transactions(transactionRequest).execute();
        System.out.println(transactionsResponse.getMessage());
    }

    @Test
    public void testWithdraw() {
        WithdrawRequest withdrawRequest = new WithdrawRequest();
        withdrawRequest.setWithdrawAccount("chendong@daex.io");
        withdrawRequest.setWithdrawAddress("123456789");
        withdrawRequest.setWithdrawPattern("1");
        withdrawRequest.setAssetCode("BTC");
        withdrawRequest.setWithdrawAmount(new BigDecimal(3));
        withdrawRequest.setWithdrawTime(new Date().toString());
        withdrawRequest.setOutNumber("wb1234567890");
        withdrawRequest.setRemark("yun");
        BaseResponse.WithdrawResponse withdrawResponse = client.withdraw(withdrawRequest).execute();
        System.out.println(((Withdraw)withdrawResponse.getData()).getBackURL() + " " + withdrawResponse.getMessage() + " " + ((Withdraw)withdrawResponse.getData()).getBizNumber());
    }

    @Test
    public void testTransfer() {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setPayAccount("chendong@daex.io");
        transferRequest.setPayPattern("1");
        transferRequest.setAssetCode("DAX");
        transferRequest.setReceAccount("尼古拉斯.凯琪");
        transferRequest.setPayAmount(new BigDecimal(20000));
        transferRequest.setPayTime("2018-07-14 14:30");
        transferRequest.setNoticeURL("http://www.baidu.com");
        transferRequest.setOutNumber("wb1234567");
        transferRequest.setRemark("haha");
        BaseResponse.TransferResponse transferResponse = client.transfer(transferRequest).execute();
        System.out.println(transferResponse.getMessage());
    }

    @Test
    public void testWithdrawConfirm() {
        WithdrawRequest withdrawRequest = new WithdrawRequest();
        withdrawRequest.setWithdrawAccount("chendong@daex.io");
        withdrawRequest.setWithdrawAddress("123456789");
        withdrawRequest.setWithdrawPattern("1");
        withdrawRequest.setAssetCode("BTC");
        withdrawRequest.setWithdrawAmount(new BigDecimal(3));
        withdrawRequest.setWithdrawTime(new Date().toString());
        withdrawRequest.setOutNumber("wb1234567890");
        withdrawRequest.setRemark("yun");
        withdrawRequest.setBizNumber("TX153155458115211305");
        withdrawRequest.setNoticeURL("12345");
        BaseResponse.WithdrawResponse withdrawResponse = client.withdrawConfirm(withdrawRequest).execute();
        System.out.println(withdrawResponse.getMessage() + " " + withdrawResponse.getData());
    }
}
