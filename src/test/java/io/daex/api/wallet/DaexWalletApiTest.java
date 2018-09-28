package io.daex.api.wallet;

import com.google.gson.Gson;
import io.daex.api.wallet.sdk.v1.DaexWalletApiClient;
import io.daex.api.wallet.sdk.v1.enums.FeeType;
import io.daex.api.wallet.sdk.v1.enums.OperationType;
import io.daex.api.wallet.sdk.v1.enums.PatternType;
import io.daex.api.wallet.sdk.v1.enums.StatusType;
import io.daex.api.wallet.sdk.v1.model.api.entity.DrawConfirmEntity;
import io.daex.api.wallet.sdk.v1.model.api.entity.DrawEntity;
import io.daex.api.wallet.sdk.v1.model.api.entity.TransferEntity;
import io.daex.api.wallet.sdk.v1.model.api.request.*;
import io.daex.api.wallet.sdk.v1.model.api.response.BaseResponse;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;


/**
 * Created by qingyun.yu on 2018/7/13.
 */
public class DaexWalletApiTest {
    private final static String endPoint = "http://localhost:5000/api";
    private final DaexWalletApiClient client = new DaexWalletApiClient(endPoint);

    @Test
    public void testCreate() {
        WalletAddressRequest walletAddressRequest = new WalletAddressRequest();
        walletAddressRequest.setAddressCount(1);
        walletAddressRequest.setAssetCode("DAX");
        walletAddressRequest.setAccount("xxx@xx.xx");
        BaseResponse.WalletAddressResponse walletAddressResponse = client.walletAddress(walletAddressRequest).execute();
        System.out.println(StatusType.statusType(walletAddressResponse.getStatus()).message());
        System.out.println(new Gson().toJson(walletAddressResponse));
    }

    @Test
    public void testBalanceStatistical() {
        BalanceRequest balanceRequest = new BalanceRequest();
        balanceRequest.setAssetCode("DAX", "BTC", "DAX");
        balanceRequest.setAccount("xxx@xx.xx");
        BaseResponse.BalancesResponse balancesResponse = client.balanceStatistical(balanceRequest).execute();
        System.out.println(new Gson().toJson(balancesResponse));
    }

    @Test
    public void testTransaction() {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAccount("xxx@xx.xx");
        transactionRequest.setSerialNumber("TX1537171***");
        BaseResponse.TransactionResponse transactionResponse = client.transaction(transactionRequest).execute();
        System.out.println(new Gson().toJson(transactionResponse));
    }

    @Test
    public void testTransactions() {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAccount("xxx@xx.xx");
        BaseResponse.TransactionsResponse transactionsResponse = client.transactions(transactionRequest).execute();
        System.out.println(new Gson().toJson(transactionsResponse));
    }

    @Test
    public void testWithdraw() {
        DrawRequest drawRequest = new DrawRequest();
        drawRequest.setAccount("xxx@xx.xx");
        drawRequest.setPayPattern(PatternType.SINGLE.pattern());
        drawRequest.setAssetCode("dax");
        drawRequest.setIsdax(FeeType.DAX.type());
        DrawEntity drawEntity = new DrawEntity();
        drawEntity.setOutNumber("91011");
        drawEntity.setPutAddress("erfwergertghrehyrheyryqqw");
        drawEntity.setPutAmount(BigDecimal.ONE);
        drawEntity.setMemo(null);
        drawEntity.setCustomerInfoFees(BigDecimal.valueOf(0.0010000000));
        DrawEntity drawEntity2 = new DrawEntity();
        drawEntity2.setOutNumber("1111112");
        drawEntity2.setPutAddress("1111112");
        drawEntity2.setPutAmount(new BigDecimal(4));

        drawRequest.setDrawData(Arrays.asList(drawEntity));
        BaseResponse.DrawResponse drawResponse = client.withdraw(drawRequest).execute();
        System.out.println(new Gson().toJson(drawResponse));
    }

    @Test
    public void testTransfer() {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setAccount("xxx@xx.xx");
        transferRequest.setPayPattern(PatternType.MULTI.pattern());
        transferRequest.setAssetCode("DAX");
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setReceAccount("bibibi**");
        transferEntity.setPayAmount(new BigDecimal(100));
        transferEntity.setOutNumber("wb1234562");
        transferEntity.setRemark("00f9011f-c3c9-47ff-9b37-d1290d0bf8a7:ZpIwHiBIiUqfSHx8VIoItd08zzPN/z38gZoIZMB4ULHQ1XBiD5VFL7leu2R");

        TransferEntity transferEntity2 = new TransferEntity();
        transferEntity2.setReceAccount("DAVIS");
        transferEntity2.setPayAmount(new BigDecimal(10));
        transferEntity2.setOutNumber("wb1234569");
        transferEntity2.setRemark("haha");
        transferRequest.setTransferData(Arrays.asList(transferEntity, transferEntity2));
        BaseResponse.TransferResponse transferResponse = client.transfer(transferRequest).execute();
        System.out.println(new Gson().toJson(transferResponse));
    }

    @Test
    public void testWithdrawConfirm() {
        DrawConfirmRequest drawConfirmRequest = new DrawConfirmRequest();
        drawConfirmRequest.setAccount("xxx@xx.xx");
        drawConfirmRequest.setPayPattern(PatternType.MULTI.pattern());
        drawConfirmRequest.setAssetCode("BTC");
        drawConfirmRequest.setNoticeURL("http://www.***.com");
        DrawConfirmEntity drawConfirmEntity = new DrawConfirmEntity();
        drawConfirmEntity.setOperations(OperationType.CONFIRM.type());
        drawConfirmEntity.setConfirmCode("e30df6412d620d2fc69bd4e512468c8c1681d6dd88391c47913a4f378d17ae11cda4ddf6fc394586c443cd64cbf65ca2e6c3f8351fa9fca7");
        DrawConfirmEntity drawConfirmEntity2 = new DrawConfirmEntity();
        drawConfirmEntity2.setOperations(OperationType.REVOCATION.type());
        drawConfirmEntity2.setConfirmCode("2a3d1a370cedf06a9ee204b148e9b56b0b897159df2f8076c1e8df2ca0448a62a5c225d469b018faa94af410c385e86451ce2d2d6b0dd169");
        drawConfirmRequest.setDrawConfirmData(Arrays.asList(drawConfirmEntity));
        BaseResponse.DrawConfirmResponse drawConfirmResponse = client.withdrawConfirm(drawConfirmRequest).execute();
        System.out.println(new Gson().toJson(drawConfirmResponse));
    }
}
