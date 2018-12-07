package io.daex.api.wallet.sdk.v1.model.api.response;


import io.daex.api.wallet.sdk.v1.model.api.entity.ResultData;
import io.daex.sdk.core.service.model.ObjectModel;

import java.util.List;

/**
 * Created by qingyun.yu on 2018/7/12.
 */
public class BaseResponse<T> implements ObjectModel {
    private String status;
    private String message;
    private T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class TransactionResponse extends BaseResponse<Transaction> {}

    public static class WalletAddressResponse extends BaseResponse<WalletAddress> {}

    public static class BalancesResponse extends BaseResponse<Balance> {}

    public static class TransactionsResponse extends BaseResponse<Transactions> {}

    public static class TransferResponse extends BaseResponse<ResultData<Transfer>> {}

    public static class DrawResponse extends BaseResponse<ResultData<Draw>> {}

    public static class DrawConfirmResponse extends BaseResponse<ResultData<DrawConfirm>> {}
}
