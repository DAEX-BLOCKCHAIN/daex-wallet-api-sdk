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

    public class TransactionResponse extends BaseResponse<Transaction> {}

    public class WalletAddressResponse extends BaseResponse<WalletAddress> {}

    public class BalancesResponse extends BaseResponse<Balance> {}

    public class TransactionsResponse extends BaseResponse<List<Transaction>> {}

    public class TransferResponse extends BaseResponse<ResultData<Transfer>> {}

    public class DrawResponse extends BaseResponse<ResultData<Draw>> {}

    public class DrawConfirmResponse extends BaseResponse<ResultData<DrawConfirm>> {}
}
