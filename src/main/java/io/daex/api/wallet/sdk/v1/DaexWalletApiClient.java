package io.daex.api.wallet.sdk.v1;

import com.google.gson.Gson;
import io.daex.api.wallet.sdk.v1.model.api.request.*;
import io.daex.api.wallet.sdk.v1.model.api.response.BaseResponse;

import io.daex.sdk.core.client.DaexClient;
import io.daex.sdk.core.http.RequestBuilder;
import io.daex.sdk.core.http.ServiceCall;
import io.daex.sdk.core.util.ResponseConverterUtils;

/**
 * Created by qingyun.yu on 2018/7/12.
 */
public class DaexWalletApiClient extends DaexClient {
    private static final String SDK_NAME = "daex_wallet_request/0.0.1-SNAPSHOT";
    private static final String BASE_URL = "service";

    public DaexWalletApiClient(String endPoint) {
        super(endPoint);
        this.setSdkName(SDK_NAME);
    }

    /**
     * @api DaexWalletApiClient.walletAddress(WalletAddressRequest.class) 创建钱包地址
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     * @apiParam {String} assetCode  资产类型,币种缩写（如：BTC）
     * @apiParam {String} account 付款账户
     * @apiParam {String=01，02} mode 地址生成方式
     * <table><tr><th>地址生成方式</th><th>描述</th></tr>
     * <tr><td>01</td><td>单个</td></tr>
     * <tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {Integer{50-1000}} [addressCount]   创建的地址数量(mode=01不需填写，mode=02必须填写)
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 用户账户
     * @apiSuccess {BigDecimal} data.accountBalance 账户DAX余额
     * @apiSuccess {BigDecimal} data.cost 创建费用，消耗的DAX数量
     * @apiSuccess {String} data.assetCode 资产类型,币种缩写（如：BTC）
     * @apiSuccess {Integer} data.addressCount 新建的地址数量
     * @apiSuccess {List} data.addressData 地址信息列表
     * @apiSuccess {String} data.addressData.address 新增地址
     * @apiSuccess {String} data.addressData.memo 地址标签（memo）
     */
    public ServiceCall<BaseResponse.WalletAddressResponse> walletAddress(WalletAddressRequest walletAddressRequest) {
        String[] pathSegments = {BASE_URL, "walletAddress"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .bodyJson(new Gson().toJsonTree(walletAddressRequest).getAsJsonObject());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.WalletAddressResponse.class), builder.getJsonBody());
    }

    /**
     * @api DaexWalletApiClient.balanceStatistical(BalanceRequest.class) 余额统计
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     * @apiParam {String} account    用户账户，主账户有权查询子账户资产
     * @apiParam {String} [assetCode]   资产类型,币种缩写（如：BTC），默认为所有资产，若填写，多个资产以"|"分隔
     * @apiParam {Integer=0(否),1(是)} [isHistory=0] 是否查询历史余额
     * @apiParam {String} [queryDate] 查询日期，isHistory=0无需不填，isHistory=1必须填写（格式：yyyy-MM-dd）
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 用户账户
     * @apiSuccess {String} data.dateTime 查询时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {List} data.assetData 资产信息列表
     * @apiSuccess {String} data.assetData.assetCode 资产类型,币种缩写（如：BTC）
     * @apiSuccess {BigDecimal} data.assetData.assetAmt 总资产数量
     * @apiSuccess {BigDecimal} data.assetData.freezeAmt 冻结资产数量
     * @apiSuccess {BigDecimal} data.assetData.usableAmt 可用资产数量
     */
    public ServiceCall<BaseResponse.BalancesResponse> balanceStatistical(BalanceRequest balanceRequest) {
        String[] pathSegments = {BASE_URL, "getBalance"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("account", balanceRequest.getAccount(), "assetCode", balanceRequest.getAssetCode());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.BalancesResponse.class), builder.getJsonBody());
    }

    /**
     * @api DaexWalletApiClient.transaction(TransactionRequest.class) 查询交易
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     * @apiParam {String} account   用户账户
     * @apiParam {String} serialNumber    交易流水号
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.serialNumber 交易流水号
     * @apiSuccess {String} data.outsideSerialNumber 外部流水号
     * @apiSuccess {String} data.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {Integer} data.transactionType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {Integer} data.capitalFlows 资金流向
     * <table><tr><th>资金流向</th><th>描述</th></tr>
     * <tr><td>1</td><td>收入</td></tr>
     * <tr><td>2</td><td>支出</td></tr></table>
     * @apiSuccess {String} data.createTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.transactionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.txHash 交易哈希
     * @apiSuccess {String} data.senderAccount 出账账户
     * @apiSuccess {String} data.recipientsAccount 入账账户
     * @apiSuccess {String} data.sender 出账地址
     * @apiSuccess {String} data.recipients 入账地址
     * @apiSuccess {String} data.memo 入账地址标签（memo）
     * @apiSuccess {String} data.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.assetAmt 金额
     * @apiSuccess {BigDecimal} data.handlingFee 交易手续费
     * @apiSuccess {String} data.assetCodeFee 交易手续费币种
     * @apiSuccess {BigDecimal} data.collectionFee 平台代理手续费
     * @apiSuccess {String} data.channel 交易渠道
     * @apiSuccess {String} data.transactionNetwork 交易网络
     * @apiSuccess {String} data.blockHash 区块哈希
     * @apiSuccess {String} data.blockHeight 区块高度
     * @apiSuccess {String} data.category 交易子类型
     * <table><tr><th>类别</th><th>描述</th></tr>
     * <tr><td>01</td><td>手续费</td></tr>
     * <tr><td>02</td><td>资金划转</td></tr>
     * <tr><td>03</td><td>创建地址</td></tr>
     * <tr><td>04</td><td>服务费</td></tr></table>
     * @apiSuccess {String} data.bindSerialNumber 关联流水号，产生手续费时原内部流水号
     * @apiSuccess {String} data.apiId API ID
     * @apiSuccess {String} data.updateTime 最后更新时间
     * @apiSuccess {String} data.txRemark 交易备注，包含交易错误信息
     * @apiSuccess {String} data.nounce 包括nounce的提现预留
     */
    public ServiceCall<BaseResponse.TransactionResponse> transaction(TransactionRequest transactionRequest) {
        String[] pathSegments = {BASE_URL, "getTransaction"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("account", transactionRequest.getAccount(), "serialNumber", transactionRequest.getSerialNumber());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransactionResponse.class));
    }

    /**
     * @api DaexWalletApiClient.transactions(TransactionRequest.class) 查询交易清单
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     * @apiParam {String} account   用户账户，用户名或注册邮箱（清算链地址），主账户有权查询子账户资产
     * @apiParam {String} [startDate]   起始日期（格式：yyyy-MM-dd HH:mm:ss)，查询起始时间，精确到秒。默认为查询当天。
     * @apiParam {String} [endDate]   截止日期（格式：yyyy-MM-dd HH:mm:ss)，查询截止时间，精确到秒。默认为查询当天。
     * @apiParam {Integer=1,2,3} [tranType] 交易类型，默认为所有
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiParam {Integer{1-1000}} [limit=10]    返回条数，当时间区间里的交易记录大于1000条时，以交易时间倒序取最近的1000条。
     * @apiParam {String} [assetCode]    资产种类，默认为所有资产。多个资产以逗号分隔
     * @apiParam {Integer=1,2,3} [accountType=1] 账户类型
     * <table><tr><th>账户类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>管理员账户</td></tr>
     * <tr><td>2</td><td>管理员手续费账户</td>
     * </tr><tr><td>3</td><td>子管理员账户</td></tr></table>
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {List} data 请求返回信息
     * @apiSuccess {String} data.serialNumber 交易流水号
     * @apiSuccess {String} data.outsideSerialNumber 外部流水号
     * @apiSuccess {String} data.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {Integer} data.transactionType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {Integer} data.capitalFlows 资金流向
     * <table><tr><th>资金流向</th><th>描述</th></tr>
     * <tr><td>1</td><td>收入</td></tr>
     * <tr><td>2</td><td>支出</td></tr></table>
     * @apiSuccess {String} data.createTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.transactionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.txHash 交易哈希
     * @apiSuccess {String} data.senderAccount 出账账户
     * @apiSuccess {String} data.recipientsAccount 入账账户
     * @apiSuccess {String} data.sender 出账地址
     * @apiSuccess {String} data.recipients 入账地址
     * @apiSuccess {String} data.memo 入账地址标签（memo）
     * @apiSuccess {String} data.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.assetAmt 金额
     * @apiSuccess {BigDecimal} data.handlingFee 交易手续费
     * @apiSuccess {String} data.assetCodeFee 交易手续费币种
     * @apiSuccess {BigDecimal} data.collectionFee 平台代理手续费
     * @apiSuccess {String} data.channel 交易渠道
     * @apiSuccess {String} data.transactionNetwork 交易网络
     * @apiSuccess {String} data.blockHash 区块哈希
     * @apiSuccess {String} data.blockHeight 区块高度
     * @apiSuccess {String} data.category 交易子类型
     * <table><tr><th>类别</th><th>描述</th></tr>
     * <tr><td>01</td><td>手续费</td></tr>
     * <tr><td>02</td><td>资金划转</td></tr>
     * <tr><td>03</td><td>创建地址</td></tr>
     * <tr><td>04</td><td>服务费</td></tr></table>
     * @apiSuccess {String} data.bindSerialNumber 关联流水号，产生手续费时原内部流水号
     * @apiSuccess {String} data.apiId API ID
     * @apiSuccess {String} data.updateTime 最后更新时间
     * @apiSuccess {String} data.txRemark 交易备注，包含交易错误信息
     * @apiSuccess {String} data.nounce 包括nounce的提现预留
     */
    public ServiceCall<BaseResponse.TransactionsResponse> transactions(TransactionRequest transactionRequest) {
        String[] pathSegments = {BASE_URL, "getTransactionList"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("assetCode", transactionRequest.getAssetCode(), "account", transactionRequest.getAccount()
                        , "endDate", transactionRequest.getEndDate(), "limit", transactionRequest.getLimit()
                        , "startDate", transactionRequest.getStartDate(), "tranType", transactionRequest.getTranType()
                        , "accountType", transactionRequest.getAccountType());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransactionsResponse.class));
    }

    /**
     * @api DaexWalletApiClient.transfer(TransferRequest.class) 转账
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     * @apiParam {String} account 付款账户
     * @apiParam {String=01,02} payPattern 付款模式
     * <table><tr><th>付款模式</th><th>描述</th></tr>
     * <tr><td>01</td><td>单笔</td></tr>
     * <tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {String} assetCode 付款资产，币种缩写
     * @apiParam {List{1..50}} transferData 转账信息列表
     * @apiParam {String} transferData.receAccount 收款人账户
     * @apiParam {BigDecimal} transferData.payAmount 付款金额
     * @apiParam {String} [transferData.outNumber] 外部流水号
     * @apiParam {String} [transferData.remark] 备注
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 付款账户
     * @apiSuccess {BigDecimal} data.totalAmount 付款总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.bizNumber 转账流水号
     * @apiSuccess {String} data.backData.outNumber 外部流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr></table>
     * @apiSuccess {String} data.backData.describe 交易说明，包含失败原因
     * @apiSuccess {String} data.backData.sucTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public ServiceCall<BaseResponse.TransferResponse> transfer(TransferRequest transferRequest) {
        String[] pathSegments = {BASE_URL, "transfer"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .bodyJson(new Gson().toJsonTree(transferRequest).getAsJsonObject());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransferResponse.class), builder.getJsonBody());
    }

    /**
     * @api DaexWalletApiClient.withdraw(DrawRequest.class) 提现
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     * @apiParam {String} account 提现账户
     * @apiParam {String=01,02} payPattern 提现模式
     * <table><tr><th>提现模式</th><th>描述</th></tr>
     * <tr><td>01</td><td>单笔</td></tr>
     * <tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {String} assetCode 提现资产，币种缩写
     * @apiParam {Integer=0,1} isdax 手续费是否为DAX
     * <table><tr><th>手续费币种</th><th>描述</th></tr>
     * <tr><td>0</td><td>提现币种</td></tr>
     * <tr><td>1</td><td>DAX</td></tr></table>
     * @apiParam {List{1..50}} drawData 提现信息列表
     * @apiParam {String} drawData.outNumber 外部流水号
     * @apiParam {String} drawData.putAddress 提现地址
     * @apiParam {BigDecimal} drawData.putAmount 提现金额
     * @apiParam {String} [drawData.customerInfoFees] 平台代理手续费
     * @apiParam {String} [drawData.memo] 提现地址标签（memo）
     * @apiParam {String} [drawData.remark] 备注
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 提现账户
     * @apiSuccess {BigDecimal} data.totalAmount 提现总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.bizNumber 提现流水号
     * @apiSuccess {String} data.backData.outNumber 外部流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {String} data.backData.confirmCode 提现确认验证码（发起提现确认的验证信息）
     * @apiSuccess {String} data.backData.describe 交易说明，包含失败原因
     * @apiSuccess {String} data.backData.applyTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public ServiceCall<BaseResponse.DrawResponse> withdraw(DrawRequest drawRequest) {
        String[] pathSegments = {BASE_URL, "putApply"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .bodyJson(new Gson().toJsonTree(drawRequest).getAsJsonObject());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.DrawResponse.class), builder.getJsonBody());
    }


    /**
     * @api DaexWalletApiClient.withdrawConfirm(DrawConfirm.class) 提现确认
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     * @apiParam {String} account 提现账户
     * @apiParam {String=01,02} payPattern 提现模式
     * <table><tr><th>提现模式</th><th>描述</th></tr><tr><td>01</td><td>单笔</td></tr><tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {String} assetCode 提现资产，币种缩写
     * @apiParam {String} noticeURL 通知地址，需与API绑定的回调地址一致
     * @apiParam {List{1..50}} drawConfirmData 提现确认信息列表
     * @apiParam {String=01,02} drawConfirmData.operations 提现操作
     * <table><tr><th>提现操作</th><th>描述</th></tr>
     * <tr><td>01</td><td>确认</td></tr>
     * <tr><td>02</td><td>撤销</td></tr></table>
     * @apiParam {String} drawConfirmData.confirmCode 提现确认验证码
     * @apiParam {String} [drawConfirmData.remark] 备注
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 提现账户
     * @apiSuccess {BigDecimal} data.totalAmount 提现总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.bizNumber 提现流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {String} data.backData.describe 交易说明
     * @apiSuccess {String} data.backData.sucTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public ServiceCall<BaseResponse.DrawConfirmResponse> withdrawConfirm(DrawConfirmRequest drawConfirmRequest) {
        String[] pathSegments = {BASE_URL, "putApplyConfirm"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .bodyJson(new Gson().toJsonTree(drawConfirmRequest).getAsJsonObject());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.DrawConfirmResponse.class), builder.getJsonBody());
    }

    /**
     * @api status 状态
     * @apiGroup Status
     * @apiVersion 1.0.0
     * @apiDescription
     * <table><tr><th>status</th><th>描述</th></tr>
     * <tr><td>00000</td><td>成功</td></tr>
     * <tr><td>10001</td><td>参数不能为空</td></tr>
     * <tr><td>10002</td><td>参数数量错误</td></tr>
     * <tr><td>10003</td><td>重复请求</td></tr>
     * <tr><td>10004</td><td>错误的报文格式</td></tr>
     * <tr><td>20001</td><td>系统内部错误</td></tr>
     * <tr><td>20002</td><td>网络异常</td></tr>
     * <tr><td>30001</td><td>账户余额不足</td></tr>
     * <tr><td>30002</td><td>发起方账户非法</td></tr>
     * <tr><td>30003</td><td>账户不存在</td></tr>
     * <tr><td>30004</td><td>日期非法</td></tr>
     * <tr><td>30005</td><td>非法的账户类型</td></tr>
     * <tr><td>30006</td><td>地址格式错误</td></tr>
     * <tr><td>30007</td><td>操作金额非法</td></tr>
     * <tr><td>30008</td><td>包含已处理的流水</td></tr>
     * <tr><td>30009</td><td>包含错误的提现确认验证码</td></tr>
     * <tr><td>40001</td><td>API类型不匹配</td></tr>
     * <tr><td>40002</td><td>非法API</td></tr>
     * <tr><td>40003</td><td>API转账已关闭</td></tr>
     * <tr><td>40004</td><td>API提现已关闭</td></tr>
     * <tr><td>99999</td><td>无数据</td></tr></table>
     *
     */
}
