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
     * @apiGroup Wallet JAVA SDK API
     * @apiVersion 1.0.0
     * @apiParam {String} assetCode  资产类型,币种缩写（如：BTC）
     * @apiParam {String} account 付款账户
     * @apiParam {String=01，02} mode 地址生成方式
     * <table><tr><th>地址生成方式</th><th>描述</th></tr>
     * <tr><td>01</td><td>单个</td></tr>
     * <tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {Integer{50-1000}} [addressCount]   创建的地址数量(mode=01不需填写，mode=02必须填写)
     * @apiParam {String=01, 02} [paymentType=1] 支付方式
     * <table><tr><th>地址生成方式</th><th>描述</th></tr>
     * <tr><td>01</td><td>使用已有额度支付</td></tr>
     * <tr><td>02</td><td>超过额度后使用DAX支付</td></tr></table>
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 用户账户
     * @apiSuccess {BigDecimal} data.accountBalance 账户DAX余额
     * @apiSuccess {BigDecimal} data.cost 创建费用，消耗的DAX数量
     * @apiSuccess {String} data.assetCode 资产类型,币种缩写（如：BTC）
     * @apiSuccess {Integer} data.addressCount 新建的地址数量
     * @apiSuccess {Integer} data.usableQuota 剩余可用额度
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
     * @apiGroup Wallet JAVA SDK API
     * @apiVersion 1.0.0
     * @apiParam {String} account    用户账户，主账户有权查询子账户资产
     * @apiParam {String} [assetCode]   资产类型,币种缩写（如：BTC），默认为所有资产，若填写，多个资产以"|"分隔
     * @apiParam {Integer=0(否),1(是)} [isHistory=0] 是否查询历史余额
     * @apiParam {String} [queryDate] 查询日期，isHistory=0无需填写，isHistory=1必须填写（格式：yyyy-MM-dd）
     * @apiParam {Integer=1,2,3} [accountType=1] 账户类型
     * <table><tr><th>账户类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>查询当前账户</td></tr>
     * <tr><td>2</td><td>手续费账户</td></tr>
     * <tr><td>3</td><td>子账户</td></tr></table>
     * @apiParam {String} [subAccount] 子账户，账户类型为3时必填，用户名或者邮箱号
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
                .query("account", balanceRequest.getAccount(), "assetCode", balanceRequest.getAssetCode()
                        , "isHistory", balanceRequest.getIsHistory(), "queryDate", balanceRequest.getQueryDate()
                        , "accountType", balanceRequest.getAccountType(), "subAccount", balanceRequest.getSubAccount());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.BalancesResponse.class), builder.getJsonBody());
    }

    /**
     * @api DaexWalletApiClient.transaction(TransactionRequest.class) 查询交易
     * @apiGroup Wallet JAVA SDK API
     * @apiVersion 1.0.0
     * @apiParam {String} account   用户账户
     * @apiParam {String} internalOrderNumber    交易流水号
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.internalOrderNumber 交易流水号
     * @apiSuccess {String} data.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {Integer} data.txType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {Integer} data.fundFlow 资金流向
     * <table><tr><th>资金流向</th><th>描述</th></tr>
     * <tr><td>1</td><td>收入</td></tr>
     * <tr><td>2</td><td>支出</td></tr></table>
     * @apiSuccess {String} data.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.txCompletionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.txHash 交易哈希
     * @apiSuccess {String} data.senderAccount 出账账户
     * @apiSuccess {String} data.recipientsAccount 入账账户
     * @apiSuccess {String} data.sender 出账地址
     * @apiSuccess {String} data.recipients 入账地址
     * @apiSuccess {String} data.memo 入账地址标签（memo）
     * @apiSuccess {String} data.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.assetAmt 金额
     * @apiSuccess {BigDecimal} data.txFees 交易手续费
     * @apiSuccess {String} data.feeToken 交易手续费币种
     * @apiSuccess {BigDecimal} data.platformFee 平台代理手续费
     * @apiSuccess {String} data.channel 交易渠道
     * @apiSuccess {String} data.txNetwork 交易网络
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
     * @apiSuccess {String} data.lastUpdateTime 最后更新时间
     * @apiSuccess {String} data.txRemark 交易备注，包含交易错误信息
     * @apiSuccess {String} data.nounce 包括nounce在内的提现预留信息
     */
    public ServiceCall<BaseResponse.TransactionResponse> transaction(TransactionRequest transactionRequest) {
        String[] pathSegments = {BASE_URL, "getTransaction"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("account", transactionRequest.getAccount(), "internalOrderNumber", transactionRequest.getInternalOrderNumber());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransactionResponse.class));
    }

    /**
     * @api DaexWalletApiClient.transactions(TransactionRequest.class) 查询交易清单
     * @apiGroup Wallet JAVA SDK API
     * @apiVersion 1.0.0
     * @apiParam {String} account   用户账户，用户名或注册邮箱（清算链地址），主账户有权查询子账户资产
     * @apiParam {String} [startDate]   起始日期（格式：yyyy-MM-dd HH:mm:ss)，查询起始时间，精确到秒。默认为查询当天。
     * @apiParam {String} [endDate]   截止日期（格式：yyyy-MM-dd HH:mm:ss)，查询截止时间，精确到秒。默认为查询当天。
     * @apiParam {Integer=1,2,3} [txType] 交易类型，默认为所有
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiParam {Integer{1-1000}} [limit=100]    返回条数，当时间区间里的交易记录大于1000条时，以交易时间倒序取最近的1000条。
     * @apiParam {String} [assetCode]    资产种类，默认为所有资产。多个资产以逗号分隔
     * @apiParam {Integer=1,2,3} [accountType=1] 账户类型
     * <table><tr><th>账户类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>管理员账户</td></tr>
     * <tr><td>2</td><td>管理员手续费账户</td>
     * </tr><tr><td>3</td><td>子管理员账户</td></tr></table>
     * @apiParam {Integer} [start=0] 索引结果从某个特定数起始
     * @apiParam {String} [subAccount] 子账户
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {Integer} data.totalCount 清单总数
     * @apiSuccess {Object} data.list 清单列表
     * @apiSuccess {String} data.list.internalOrderNumber 交易流水号
     * @apiSuccess {String} data.list.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.list.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {Integer} data.list.txType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {Integer} data.list.fundFlow 资金流向
     * <table><tr><th>资金流向</th><th>描述</th></tr>
     * <tr><td>1</td><td>收入</td></tr>
     * <tr><td>2</td><td>支出</td></tr></table>
     * @apiSuccess {String} data.list.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.list.txCompletionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.list.txHash 交易哈希
     * @apiSuccess {String} data.list.senderAccount 出账账户
     * @apiSuccess {String} data.list.recipientsAccount 入账账户
     * @apiSuccess {String} data.list.sender 出账地址
     * @apiSuccess {String} data.list.recipients 入账地址
     * @apiSuccess {String} data.list.memo 入账地址标签（memo）
     * @apiSuccess {String} data.list.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.list.assetAmt 金额
     * @apiSuccess {BigDecimal} data.list.txFees 交易手续费
     * @apiSuccess {String} data.list.feeToken 交易手续费币种
     * @apiSuccess {BigDecimal} data.list.platformFee 平台代理手续费
     * @apiSuccess {String} data.list.channel 交易渠道
     * @apiSuccess {String} data.list.txNetwork 交易网络
     * @apiSuccess {String} data.list.blockHash 区块哈希
     * @apiSuccess {String} data.list.blockHeight 区块高度
     * @apiSuccess {String} data.list.category 交易子类型
     * <table><tr><th>类别</th><th>描述</th></tr>
     * <tr><td>01</td><td>手续费</td></tr>
     * <tr><td>02</td><td>资金划转</td></tr>
     * <tr><td>03</td><td>创建地址</td></tr>
     * <tr><td>04</td><td>服务费</td></tr></table>
     * @apiSuccess {String} data.list.bindSerialNumber 关联流水号，产生手续费时原内部流水号
     * @apiSuccess {String} data.list.apiId API ID
     * @apiSuccess {String} data.list.lastUpdateTime 最后更新时间
     * @apiSuccess {String} data.list.txRemark 交易备注，包含交易错误信息
     * @apiSuccess {String} data.list.nounce 包括nounce在内的提现预留信息
     */
    public ServiceCall<BaseResponse.TransactionsResponse> transactions(TransactionRequest transactionRequest) {
        String[] pathSegments = {BASE_URL, "getTransactionList"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("assetCode", transactionRequest.getAssetCode(), "account", transactionRequest.getAccount()
                        , "endDate", transactionRequest.getEndDate(), "limit", transactionRequest.getLimit()
                        , "startDate", transactionRequest.getStartDate(), "txType", transactionRequest.getTxType()
                        , "accountType", transactionRequest.getAccountType(), "start", transactionRequest.getStart()
                        , "subAccount", transactionRequest.getSubAccount());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransactionsResponse.class));
    }

    /**
     * @api DaexWalletApiClient.transfer(TransferRequest.class) 转账
     * @apiGroup Wallet JAVA SDK API
     * @apiVersion 1.0.0
     * @apiParam {String} account 付款账户
     * @apiParam {String=01,02} payPattern 付款模式
     * <table><tr><th>付款模式</th><th>描述</th></tr>
     * <tr><td>01</td><td>单笔</td></tr>
     * <tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {String} assetCode 付款资产，币种缩写
     * @apiParam {List{1..50}} transferData 转账信息列表
     * @apiParam {String} transferData.recipientsAccount 收款人账户
     * @apiParam {BigDecimal} transferData.payAmount 付款金额
     * @apiParam {String} [transferData.externalOrderNumber] 外部流水号
     * @apiParam {String} [transferData.remark] 备注
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 付款账户
     * @apiSuccess {BigDecimal} data.totalAmount 付款总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.internalOrderNumber 转账流水号
     * @apiSuccess {String} data.backData.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr></table>
     * @apiSuccess {String} data.backData.describe 交易说明，包含失败原因
     * @apiSuccess {String} data.backData.txCompletionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public ServiceCall<BaseResponse.TransferResponse> transfer(TransferRequest transferRequest) {
        String[] pathSegments = {BASE_URL, "transfer"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .bodyJson(new Gson().toJsonTree(transferRequest).getAsJsonObject());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransferResponse.class), builder.getJsonBody());
    }

    /**
     * @api DaexWalletApiClient.withdraw(DrawRequest.class) 提现
     * @apiGroup Wallet JAVA SDK API
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
     * @apiParam {String} drawData.externalOrderNumber 外部流水号
     * @apiParam {String} drawData.putAddress 提现地址
     * @apiParam {BigDecimal} drawData.putAmount 提现金额
     * @apiParam {String} [drawData.platformFee] 平台代理手续费
     * @apiParam {String} [drawData.memo] 提现地址标签（memo）
     * @apiParam {String} [drawData.remark] 备注
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 提现账户
     * @apiSuccess {BigDecimal} data.totalAmount 提现总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.internalOrderNumber 提现流水号
     * @apiSuccess {String} data.backData.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {String} data.backData.confirmCode 提现确认验证码（发起提现确认的验证信息，验证码过期时间为15分钟）
     * @apiSuccess {String} data.backData.describe 交易说明，包含失败原因
     * @apiSuccess {String} data.backData.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public ServiceCall<BaseResponse.DrawResponse> withdraw(DrawRequest drawRequest) {
        String[] pathSegments = {BASE_URL, "putApply"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .bodyJson(new Gson().toJsonTree(drawRequest).getAsJsonObject());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.DrawResponse.class), builder.getJsonBody());
    }


    /**
     * @api DaexWalletApiClient.withdrawConfirm(DrawConfirm.class) 提现确认
     * @apiGroup Wallet JAVA SDK API
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
     * @apiSuccess {String} data.backData.internalOrderNumber 提现流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>交易撤销</td></tr>
     * <tr><td>05</td><td>交易申请待确认</td></tr></table>
     * @apiSuccess {String} data.backData.describe 交易说明
     * @apiSuccess {String} data.backData.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
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

    /**
     * @api {POST} https://www.daex.pro/api/service/walletAddress 创建钱包地址（tAPi）
     * @apiGroup Wallet API
     * @apiVersion 1.0.0
     * @apiHeader {String} X-Authorization-Nonce 加签随机字符串，UUID随机串
     * @apiHeader {String} X-Authorization-Timestamp 加签时间戳，精确到秒
     * @apiHeader {String} X-Authorization-Sign 加签串，apiId:signature，请查看<a href='https://github.com/DAEX-BLOCKCHAIN/daex-wallet-api-sdk/wiki/DAEX-Wallet-Data-Signature-Standard'>DAEX Wallet Data Signature Standard</a>
     * @apiHeader {String} Content-Type application/json
     * @apiHeaderExample {json} Header-Example:
     * {
     *     "X-Authorization-Nonce": "4000a822-***-07dcc397eca1",
     *     "X-Authorization-Timestamp": "1542010546",
     *     "X-Authorization-Sign": "00f9011f-***-d1290d0bf8a7:Tt+TQQnvW2geW***butDvjnLiQdA==",
     *     "Content-Type": "application/json"
     * }
     *
     * @apiParam {String} assetCode  资产类型,币种缩写（如：BTC）
     * @apiParam {String} account 付款账户
     * @apiParam {String=01，02} mode 地址生成方式
     * <table><tr><th>地址生成方式</th><th>描述</th></tr>
     * <tr><td>01</td><td>单个</td></tr>
     * <tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {Integer{50-1000}} [addressCount]   创建的地址数量(mode=01不需填写，mode=02必须填写)
     * @apiParam {String=01, 02} [paymentType=1] 支付方式
     * <table><tr><th>地址生成方式</th><th>描述</th></tr>
     * <tr><td>01</td><td>使用已有额度支付</td></tr>
     * <tr><td>02</td><td>超过额度后使用DAX支付</td></tr></table>
     * @apiParamExample {json} Request-Example:
     * {
     *     "account":"yu***un@daex.io",
     *     "assetCode":"DAX",
     *     "addressCount":1,
     *     "mode":"01"
     * }
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 用户账户
     * @apiSuccess {BigDecimal} data.accountBalance 账户DAX余额
     * @apiSuccess {BigDecimal} data.cost 创建费用，消耗的DAX数量
     * @apiSuccess {String} data.assetCode 资产类型,币种缩写（如：BTC）
     * @apiSuccess {Integer} data.addressCount 新建的地址数量
     * @apiSuccess {Integer} data.usableQuota 剩余可用额度
     * @apiSuccess {List} data.addressData 地址信息列表
     * @apiSuccess {String} data.addressData.address 新增地址
     * @apiSuccess {String} data.addressData.memo 地址标签（memo）
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "status":"00000",
     *     "message":"成功",
     *     "data":{
     *         "account":"yu***un@daex.io",
     *         "accountBalance":12860.0000000000,
     *         "cost":0,
     *         "assetCode":"dax",
     *         "addressCount":1,
     *         "addressCount":1,
     *         "addressData":[
     *              {
     *                 "address":"0xacac31a4ca30240ffa93f2a6c611eb031fdaa9d1",
     *                 "memo":"E0LkHvIlHx"
     *              }
     *         ]
     *     }
     * }
     */

    /**
     * @api {GET} https://www.daex.pro/api/service/getBalance 余额统计（mAPi）
     * @apiGroup Wallet API
     * @apiVersion 1.0.0
     * @apiHeader {String} X-Authorization-Nonce 加签随机字符串，UUID随机串
     * @apiHeader {String} X-Authorization-Timestamp 加签时间戳，精确到秒
     * @apiHeader {String} X-Authorization-Sign 加签串，apiId:signature，请查看<a href='https://github.com/DAEX-BLOCKCHAIN/daex-wallet-api-sdk/wiki/DAEX-Wallet-Data-Signature-Standard'>DAEX Wallet Data Signature Standard</a>
     * @apiHeaderExample {json} Header-Example:
     * {
     *     "X-Authorization-Nonce": "4000a822-***-07dcc397eca1",
     *     "X-Authorization-Timestamp": "1542010546",
     *     "X-Authorization-Sign": "00f9011f-***-d1290d0bf8a7:Tt+TQQnvW2geW***butDvjnLiQdA=="
     * }
     * @apiParam {String} account    用户账户，主账户有权查询子账户资产
     * @apiParam {String} [assetCode]   资产类型,币种缩写（如：BTC），默认为所有资产，若填写，多个资产以"|"分隔
     * @apiParam {Integer=0(否),1(是)} [isHistory=0] 是否查询历史余额
     * @apiParam {String} [queryDate] 查询日期，isHistory=0无需填写，isHistory=1必须填写（格式：yyyy-MM-dd）
     * @apiParam {Integer=1,2,3} [accountType=1] 账户类型
     * <table><tr><th>账户类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>查询当前账户</td></tr>
     * <tr><td>2</td><td>手续费账户</td></tr>
     * <tr><td>3</td><td>子账户</td></tr></table>
     * @apiParam {String} [subAccount] 子账户，账户类型为3时必填，用户名或者邮箱号
     * @apiParamExample {quest} Request-Example:
     *  account=accountName&assetCode=DAX|BTC|DAX
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
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "status":"00000",
     *     "message":"成功",
     *     "data":{
     *         "account":"yuqingyun@daex.io",
     *         "dateTime":"2018-11-12 16:27:02",
     *         "assetData":[
     *              {
     *                 "assetCode":"btc",
     *                 "assetAmt":1000.0000000000,
     *                 "freezeAmt":23.0000000000,
     *                 "usableAmt":977.0000000000
     *              },
     *              {
     *                  "assetCode":"dax",
     *                  "assetAmt":12860.0000000000,
     *                  "freezeAmt":-60.0000000000,
     *                  "usableAmt":12920.0000000000
     *              }
     *         ]
     *     }
     * }
     */

    /**
     * @api {GET} https://www.daex.pro/api/service/getTransaction 查询交易（mAPi）
     * @apiGroup Wallet API
     * @apiVersion 1.0.0
     * @apiHeader {String} X-Authorization-Nonce 加签随机字符串，UUID随机串
     * @apiHeader {String} X-Authorization-Timestamp 加签时间戳，精确到秒
     * @apiHeader {String} X-Authorization-Sign 加签串，apiId:signature，请查看<a href='https://github.com/DAEX-BLOCKCHAIN/daex-wallet-api-sdk/wiki/DAEX-Wallet-Data-Signature-Standard'>DAEX Wallet Data Signature Standard</a>
     * @apiHeaderExample {json} Header-Example:
     * {
     *     "X-Authorization-Nonce": "4000a822-***-07dcc397eca1",
     *     "X-Authorization-Timestamp": "1542010546",
     *     "X-Authorization-Sign": "00f9011f-***-d1290d0bf8a7:Tt+TQQnvW2geW***butDvjnLiQdA=="
     * }
     * @apiParam {String} account   用户账户
     * @apiParam {String} internalOrderNumber    交易流水号
     * @apiParamExample {quest} Request-Example:
     *  account=accountName&serialNumber=102154201348605049469773
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.internalOrderNumber 交易流水号
     * @apiSuccess {String} data.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {Integer} data.txType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {Integer} data.fundFlow 资金流向
     * <table><tr><th>资金流向</th><th>描述</th></tr>
     * <tr><td>1</td><td>收入</td></tr>
     * <tr><td>2</td><td>支出</td></tr></table>
     * @apiSuccess {String} data.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.txCompletionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.txHash 交易哈希
     * @apiSuccess {String} data.senderAccount 出账账户
     * @apiSuccess {String} data.recipientsAccount 入账账户
     * @apiSuccess {String} data.sender 出账地址
     * @apiSuccess {String} data.recipients 入账地址
     * @apiSuccess {String} data.memo 入账地址标签（memo）
     * @apiSuccess {String} data.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.assetAmt 金额
     * @apiSuccess {BigDecimal} data.txFees 交易手续费
     * @apiSuccess {String} data.feeToken 交易手续费币种
     * @apiSuccess {BigDecimal} data.platformFee 平台代理手续费
     * @apiSuccess {String} data.channel 交易渠道
     * @apiSuccess {String} data.txNetwork 交易网络
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
     * @apiSuccess {String} data.lastUpdateTime 最后更新时间
     * @apiSuccess {String} data.txRemark 交易备注，包含交易错误信息
     * @apiSuccess {String} data.nounce 包括nounce在内的提现预留信息
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "status":"00000",
     *     "message":"成功",
     *     "data": [
     *          {
     *              "internalOrderNumber":"102154201348605661918377",
     *              "externalOrderNumber":"wb1234569",
     *              "status":"01",
     *              "txType":3,
     *              "fundFlow":2,
     *              "txTime":"2018-11-12 17:04:46",
     *              "txCompletionTime":"2018-11-12 17:04:46",
     *              "senderAccount":"admin123",
     *              "recipientsAccount":"DAVIS",
     *              "sender":"",
     *              "recipients":"",
     *              "memo":"",
     *              "assetCode":"DAX",
     *              "assetAmt":10.0000000000,
     *              "handlingFee":0E-10,
     *              "feeToken":"DAX",
     *              "txFees":0E-10,
     *              "channel":"API",
     *              "txNetwork":"",
     *              "blockHash":"",
     *              "blockHeight":"",
     *              "category":"",
     *              "apiId":"00f9011f-***-d1290d0bf8a7",
     *              "lastUpdateTime":"2018-11-12 17:04:46",
     *              "txRemark":"",
     *              "nounce":""
     *          }
     *     ]
     * }
     */

    /**
     * @api {GET} https://www.daex.pro/api/service/getTransactionList 查询交易清单（mAPi）
     * @apiGroup Wallet API
     * @apiVersion 1.0.0
     * @apiHeader {String} X-Authorization-Nonce 加签随机字符串，UUID随机串
     * @apiHeader {String} X-Authorization-Timestamp 加签时间戳，精确到秒
     * @apiHeader {String} X-Authorization-Sign 加签串，apiId:signature，请查看<a href='https://github.com/DAEX-BLOCKCHAIN/daex-wallet-api-sdk/wiki/DAEX-Wallet-Data-Signature-Standard'>DAEX Wallet Data Signature Standard</a>
     * @apiHeaderExample {json} Header-Example:
     * {
     *     "X-Authorization-Nonce": "4000a822-***-07dcc397eca1",
     *     "X-Authorization-Timestamp": "1542010546",
     *     "X-Authorization-Sign": "00f9011f-***-d1290d0bf8a7:Tt+TQQnvW2geW***butDvjnLiQdA=="
     * }
     * @apiParam {String} account   用户账户，用户名或注册邮箱（清算链地址），主账户有权查询子账户资产
     * @apiParam {String} [startDate]   起始日期（格式：yyyy-MM-dd HH:mm:ss)，查询起始时间，精确到秒。默认为查询当天。
     * @apiParam {String} [endDate]   截止日期（格式：yyyy-MM-dd HH:mm:ss)，查询截止时间，精确到秒。默认为查询当天。
     * @apiParam {Integer=1,2,3} [txType] 交易类型，默认为所有
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiParam {Integer{1-1000}} [limit=100]    返回条数，当时间区间里的交易记录大于1000条时，以交易时间倒序取最近的1000条。
     * @apiParam {String} [assetCode]    资产种类，默认为所有资产。多个资产以逗号分隔
     * @apiParam {Integer=1,2,3} [accountType=1] 账户类型
     * <table><tr><th>账户类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>管理员账户</td></tr>
     * <tr><td>2</td><td>管理员手续费账户</td>
     * </tr><tr><td>3</td><td>子管理员账户</td></tr></table>
     * @apiParam {Integer} [start=0] 索引结果从某个特定数起始
     * @apiParam {String} [subAccount] 子账户
     * @apiParamExample {quest} Request-Example:
     *  account=accountName&limit=2
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {List} data 请求返回信息
     * @apiSuccess {Integer} data.totalCount 清单总数
     * @apiSuccess {Object} data.list 清单列表
     * @apiSuccess {String} data.list.internalOrderNumber 交易流水号
     * @apiSuccess {String} data.list.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.list.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {Integer} data.list.txType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr>
     * <tr><td>1</td><td>充值</td></tr>
     * <tr><td>2</td><td>提现</td></tr>
     * <tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {Integer} data.list.fundFlow 资金流向
     * <table><tr><th>资金流向</th><th>描述</th></tr>
     * <tr><td>1</td><td>收入</td></tr>
     * <tr><td>2</td><td>支出</td></tr></table>
     * @apiSuccess {String} data.list.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.list.txCompletionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.list.txHash 交易哈希
     * @apiSuccess {String} data.list.senderAccount 出账账户
     * @apiSuccess {String} data.list.recipientsAccount 入账账户
     * @apiSuccess {String} data.list.sender 出账地址
     * @apiSuccess {String} data.list.recipients 入账地址
     * @apiSuccess {String} data.list.memo 入账地址标签（memo）
     * @apiSuccess {String} data.list.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.list.assetAmt 金额
     * @apiSuccess {BigDecimal} data.list.txFees 交易手续费
     * @apiSuccess {String} data.list.feeToken 交易手续费币种
     * @apiSuccess {BigDecimal} data.list.platformFee 平台代理手续费
     * @apiSuccess {String} data.list.channel 交易渠道
     * @apiSuccess {String} data.list.txNetwork 交易网络
     * @apiSuccess {String} data.list.blockHash 区块哈希
     * @apiSuccess {String} data.list.blockHeight 区块高度
     * @apiSuccess {String} data.list.category 交易子类型
     * <table><tr><th>类别</th><th>描述</th></tr>
     * <tr><td>01</td><td>手续费</td></tr>
     * <tr><td>02</td><td>资金划转</td></tr>
     * <tr><td>03</td><td>创建地址</td></tr>
     * <tr><td>04</td><td>服务费</td></tr></table>
     * @apiSuccess {String} data.list.bindSerialNumber 关联流水号，产生手续费时原内部流水号
     * @apiSuccess {String} data.list.apiId API ID
     * @apiSuccess {String} data.list.lastUpdateTime 最后更新时间
     * @apiSuccess {String} data.list.txRemark 交易备注，包含交易错误信息
     * @apiSuccess {String} data.list.nounce 包括nounce在内的提现预留信息
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "status":"00000",
     *     "message":"成功",
     *     "data": {
     *          "totalCount"：1,
     *          "list":[
     *              {
     *                  "internalOrderNumber":"102154201348605661918377",
     *                  "externalOrderNumber":"wb1234569",
     *                  "status":"01",
     *                  "txType":3,
     *                  "fundFlow":2,
     *                  "txTime":"2018-11-12 17:04:46",
     *                  "txCompletionTime":"2018-11-12 17:04:46",
     *                  "senderAccount":"admin123",
     *                  "recipientsAccount":"DAVIS",
     *                  "sender":"",
     *                  "recipients":"",
     *                  "memo":"",
     *                  "assetCode":"DAX",
     *                  "assetAmt":10.0000000000,
     *                  "handlingFee":0E-10,
     *                  "feeToken":"DAX",
     *                  "txFees":0E-10,
     *                  "channel":"API",
     *                  "txNetwork":"",
     *                  "blockHash":"",
     *                  "blockHeight":"",
     *                  "category":"",
     *                  "apiId":"00f9011f-***-d1290d0bf8a7",
     *                  "lastUpdateTime":"2018-11-12 17:04:46",
     *                  "txRemark":"",
     *                  "nounce":""
     *              }
     *          ]
     *     }
     * }
     */

    /**
     * @api {POST} https://www.daex.pro/api/service/transfer 转账（tApi）
     * @apiGroup Wallet API
     * @apiVersion 1.0.0
     * @apiHeader {String} X-Authorization-Nonce 加签随机字符串，UUID随机串
     * @apiHeader {String} X-Authorization-Timestamp 加签时间戳，精确到秒
     * @apiHeader {String} X-Authorization-Sign 加签串，apiId:signature，请查看<a href='https://github.com/DAEX-BLOCKCHAIN/daex-wallet-api-sdk/wiki/DAEX-Wallet-Data-Signature-Standard'>DAEX Wallet Data Signature Standard</a>
     * @apiHeader {String} Content-Type application/json
     * @apiHeaderExample {json} Header-Example:
     * {
     *     "X-Authorization-Nonce": "4000a822-***-07dcc397eca1",
     *     "X-Authorization-Timestamp": "1542010546",
     *     "X-Authorization-Sign": "00f9011f-***-d1290d0bf8a7:Tt+TQQnvW2geW***butDvjnLiQdA==",
     *     "Content-Type": "application/json"
     * }
     * @apiParam {String} account 付款账户
     * @apiParam {String=01,02} payPattern 付款模式
     * <table><tr><th>付款模式</th><th>描述</th></tr>
     * <tr><td>01</td><td>单笔</td></tr>
     * <tr><td>02</td><td>批量</td></tr></table>
     * @apiParam {String} assetCode 付款资产，币种缩写
     * @apiParam {List{1..50}} transferData 转账信息列表
     * @apiParam {String} transferData.recipientsAccount 收款人账户
     * @apiParam {BigDecimal} transferData.payAmount 付款金额
     * @apiParam {String} [transferData.externalOrderNumber] 外部流水号
     * @apiParam {String} [transferData.remark] 备注
     * @apiParamExample {json} Request-Example:
     * {
     *     "account":"yu***un@daex.io",
     *     "payPattern":"02",
     *     "assetCode":"DAX",
     *     "transferData":[
     *          {
     *             "receAccount":"bibibiBI2",
     *             "payAmount":100,
     *             "outNumber":"wb1234562",
     *             "remark":"haha"
     *          }
     *     ]
     * }
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 付款账户
     * @apiSuccess {BigDecimal} data.totalAmount 付款总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.internalOrderNumber 转账流水号
     * @apiSuccess {String} data.backData.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr></table>
     * @apiSuccess {String} data.backData.describe 交易说明，包含失败原因
     * @apiSuccess {String} data.backData.txCompletionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "status":"00000",
     *     "message":"成功",
     *     "data":{
     *         "account":"yu***un@daex.io",
     *         "totalAmount":110,
     *         "usableAmt":99562.0000000000,
     *         "backData":[
     *              {
     *                  "internalOrderNumber":"102154201348605049469773",
     *                  "externalOrderNumber":"wb1234562",
     *                  "status":"01",
     *                  "describe":"转账成功",
     *                  "txCompletionTime":"2018-11-12 17:04:46"
     *              }
     *         ]
     *     }
     * }
     */

    /**
     * @api {POST} https://www.daex.pro/api/service/putApply 提现（tApi）
     * @apiGroup Wallet API
     * @apiVersion 1.0.0
     * @apiHeader {String} X-Authorization-Nonce 加签随机字符串，UUID随机串
     * @apiHeader {String} X-Authorization-Timestamp 加签时间戳，精确到秒
     * @apiHeader {String} X-Authorization-Sign 加签串，apiId:signature，请查看<a href='https://github.com/DAEX-BLOCKCHAIN/daex-wallet-api-sdk/wiki/DAEX-Wallet-Data-Signature-Standard'>DAEX Wallet Data Signature Standard</a>
     * @apiHeader {String} Content-Type application/json
     * @apiHeaderExample {json} Header-Example:
     * {
     *     "X-Authorization-Nonce": "4000a822-***-07dcc397eca1",
     *     "X-Authorization-Timestamp": "1542010546",
     *     "X-Authorization-Sign": "00f9011f-***-d1290d0bf8a7:Tt+TQQnvW2geW***butDvjnLiQdA==",
     *     "Content-Type": "application/json"
     * }
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
     * @apiParam {String} drawData.externalOrderNumber 外部流水号
     * @apiParam {String} drawData.putAddress 提现地址
     * @apiParam {BigDecimal} drawData.putAmount 提现金额
     * @apiParam {String} [drawData.platformFee] 平台代理手续费
     * @apiParam {String} [drawData.memo] 提现地址标签（memo）
     * @apiParam {String} [drawData.remark] 备注
     * @apiParamExample {json} Request-Example:
     * {
     *     "account":"yu***un@daex.io",
     *     "payPattern":"01",
     *     "assetCode":"dax",
     *     "isdax":1,
     *     "drawData":[
     *          {
     *              "putAddress":"erfwergertghrehyrheyryqqw",
     *              "putAmount":36,
     *              "outNumber":"91011",
     *              "customerInfoFees":0.001
     *          }
     *     ]
     * }
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 提现账户
     * @apiSuccess {BigDecimal} data.totalAmount 提现总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.internalOrderNumber 提现流水号
     * @apiSuccess {String} data.backData.externalOrderNumber 外部流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>提现待确认</td></tr>
     * <tr><td>05</td><td>提现撤销</td></tr></table>
     * @apiSuccess {String} data.backData.confirmCode 提现确认验证码（发起提现确认的验证信息，验证码过期时间为15分钟）
     * @apiSuccess {String} data.backData.describe 交易说明，包含失败原因
     * @apiSuccess {String} data.backData.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "status":"00000",
     *     "message":"成功",
     *     "data":{
     *         "account":"yu***un@daex.io",
     *         "totalAmount":36,
     *         "usableAmt":99964.0000000000,
     *         "backData":[
     *              {
     *                  "internalOrderNumber":"101154201239856769304989",
     *                  "externalOrderNumber":"91011",
     *                  "status":"05",
     *                  "describe":"提现申请成功",
     *                  "confirmCode":"2f1ce4a***2f3877de",
     *                  "txTime":"2018-11-12 16:46:39"
     *              }
     *         ]
     *     }
     * }
     *
     */


    /**
     * @api {POST} https://www.daex.pro/api/service/putApplyConfirm 提现确认（tcApi）
     * @apiGroup Wallet API
     * @apiVersion 1.0.0
     * @apiHeader {String} X-Authorization-Nonce 加签随机字符串，UUID随机串
     * @apiHeader {String} X-Authorization-Timestamp 加签时间戳，精确到秒
     * @apiHeader {String} X-Authorization-Sign 加签串，apiId:signature，请查看<a href='https://github.com/DAEX-BLOCKCHAIN/daex-wallet-api-sdk/wiki/DAEX-Wallet-Data-Signature-Standard'>DAEX Wallet Data Signature Standard</a>
     * @apiHeader {String} Content-Type application/json
     * @apiHeaderExample {json} Header-Example:
     * {
     *     "X-Authorization-Nonce": "4000a822-***-07dcc397eca1",
     *     "X-Authorization-Timestamp": "1542010546",
     *     "X-Authorization-Sign": "00f9011f-***-d1290d0bf8a7:Tt+TQQnvW2geW***butDvjnLiQdA==",
     *     "Content-Type": "application/json"
     * }
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
     * @apiParamExample {json} Request-Example:
     * {
     *     "account":"yu***un@daex.io",
     *     "payPattern":"02",
     *     "assetCode":"dax",
     *     "noticeURL":"your_notice_url",
     *     "drawConfirmData": [
     *          {
     *              "confirmCode":"b870e652***fe62e96e04f",
     *              "operations":"01"
     *          }
     *     ]
     * }
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 提现账户
     * @apiSuccess {BigDecimal} data.totalAmount 提现总金额
     * @apiSuccess {BigDecimal} data.usableAmt 账户可用余额
     * @apiSuccess {List} data.backData 返回数据列表
     * @apiSuccess {String} data.backData.internalOrderNumber 提现流水号
     * @apiSuccess {String} data.backData.status 交易状态
     * <table><tr><th>交易状态</th><th>描述</th></tr>
     * <tr><td>01</td><td>交易完成</td></tr>
     * <tr><td>02</td><td>交易待处理</td></tr>
     * <tr><td>03</td><td>交易失败</td></tr>
     * <tr><td>04</td><td>交易撤销</td></tr>
     * <tr><td>05</td><td>交易申请待确认</td></tr></table>
     * @apiSuccess {String} data.backData.describe 交易说明
     * @apiSuccess {String} data.backData.txTime 交易申请时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "status":"00000",
     *     "message":"成功",
     *     "data":{
     *         "account":"yuqingyun@daex.io",
     *         "usableAmt":99526.0000000000,
     *         "backData":[
     *              "internalOrderNumber":"101154201461825757599950",
     *              "status":"02",
     *              "txTime":"2018-11-12 17:23:54",
     *              "describe":"操作成功"
     *         ]
     *     }
     * }
     */
}
