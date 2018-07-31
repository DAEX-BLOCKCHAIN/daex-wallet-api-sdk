package io.daex.api.wallet.sdk.v1;

import io.daex.api.wallet.sdk.v1.model.*;
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
     *
     * @apiParam {String} assetCode  数字货币缩写（如：BTC）
     * @apiParam {String} payAccount 付款账户
     * @apiParam {Integer{1-100}} addressCount   创建的地址数量
     * @apiParam {String=1,2} addressType    创建地址类型
     * <table><tr><th>地址类型</th><th>描述</th></tr><tr><td>1</td><td>充值</td></tr><tr><td>2</td><td>其他</td></tr></table>
     *
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {BigDecimal} data.accountBalance 账户余额(DAX)
     * @apiSuccess {BigDecimal} data.cost 消耗的DAX数量（计算公式：addressCount*10）
     * @apiSuccess {String} data.assetCode 数字货币缩写（如：BTC）
     * @apiSuccess {Integer} data.addressCount 创建的地址数量
     * @apiSuccess {List} data.addressList 地址集合
     * @apiSuccess {Integer} data.useAddressCount 可用地址数量
     * @apiSuccess {String} data.memo 地址标签集
     *
     */
    public ServiceCall<BaseResponse.WalletAddressResponse> walletAddress(WalletAddressRequest walletAddressRequest) {
        String[] pathSegments = {BASE_URL, "walletAddress"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments));
        builder.form("assetCode", walletAddressRequest.getAssetCode(), "payAccount", walletAddressRequest.getPayAccount()
                , "addressCount", walletAddressRequest.getAddressCount(), "addressType", walletAddressRequest.getAddressType());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.WalletAddressResponse.class));
    }

    /**
     * @api DaexWalletApiClient.balanceStatistical(BalanceRequest.class) 余额统计
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     *
     * @apiParam {String} payAccount    用户账户
     * @apiParam {String} [assetCode]   数字货币缩写（如：BTC）
     *
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.account 用户账户
     * @apiSuccess {String} data.assetCode 数字货币缩写（如：BTC）
     * @apiSuccess {BigDecimal} data.assetAmt 资产数量
     * @apiSuccess {BigDecimal} data.freezeAmt 冻结资产数量
     * @apiSuccess {BigDecimal} data.usableAmt 可用资产数量
     *
     */
    public ServiceCall<BaseResponse.BalancesResponse> balanceStatistical(BalanceRequest balanceRequest) {
        String[] pathSegments = {BASE_URL, "getBalance"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("assetCode", balanceRequest.getAssetCode(), "payAccount", balanceRequest.getPayAccount());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.BalancesResponse.class));
    }

    /**
     * @api DaexWalletApiClient.transaction(TransactionRequest.class) 查询交易
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     *
     * @apiParam {String} assetCode   数字货币缩写（如：BTC）
     * @apiParam {Integer=1,2,3} tranType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr><tr><td>1</td><td>充值</td></tr><tr><td>2</td><td>提现</td></tr><tr><td>3</td><td>转账</td></tr></table>
     * @apiParam {String} [outsideSerialNumber]    外部流水号即用户生成的流水号（与serialNumber选填一种）
     * @apiParam {String} [serialNumber]    由清算链生成的交易流水号（与outsideSerialNumber选填一种）
     *
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.serialNumber 流水号
     * @apiSuccess {String} data.outsideSerialNumber 外部流水号
     * @apiSuccess {Integer} data.transactionResult 交易结果
     * <table><tr><th>交易结果</th><th>描述</th></tr><tr><td>1</td><td>交易完成</td></tr><tr><td>2</td><td>待处理</td></tr><tr><td>3</td><td>交易失败</td></tr><tr><td>4</td><td>交易不存在</td></tr></table>
     * @apiSuccess {Integer} data.transactionType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr><tr><td>1</td><td>充值</td></tr><tr><td>2</td><td>提现</td></tr><tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {String} data.transactionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.transactionTimestamp 交易时间戳
     * @apiSuccess {String} data.transactionHash 交易哈希
     * @apiSuccess {String} data.transferOut 出账方
     * @apiSuccess {String} data.transferInto 入账方
     * @apiSuccess {String} data.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.assetAmt 金额
     * @apiSuccess {BigDecimal} data.handlingFee 手续费
     * @apiSuccess {String} data.transactionNetwork 交易网络
     * @apiSuccess {String} data.blockHash 区块哈希
     * @apiSuccess {BigDecimal} data.blockHeight 区块高度
     * @apiSuccess {BigDecimal} data.blockTime 区块时间戳
     *
     */
    public ServiceCall<BaseResponse.TransactionResponse> transaction(TransactionRequest transactionRequest) {
        String[] pathSegments = {BASE_URL, "getTransaction"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("assetCode", transactionRequest.getAssetCode(), "outsideSerialNumber", transactionRequest.getOutsideSerialNumber()
                        , "serialNumber", transactionRequest.getSerialNumber(), "tranType", transactionRequest.getTranType());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransactionResponse.class));
    }

    /**
     * @api DaexWalletApiClient.transactions(TransactionRequest.class) 查询交易清单
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     *
     * @apiParam {String} payAccount   用户账户
     * @apiParam {String} [startDate]   起始日期
     * @apiParam {String} [endDate]   截止日期
     * @apiParam {Integer=1,2,3} [tranType] 交易类型，默认为所有
     * <table><tr><th>交易类型</th><th>描述</th></tr><tr><td>1</td><td>充值</td></tr><tr><td>2</td><td>提现</td></tr><tr><td>3</td><td>转账</td></tr></table>
     * @apiParam {Integer{1-1000}} [limit=10]    返回条数
     * @apiParam {String} [assetCode]    资产种类，默认为所有资产。多个资产以逗号分隔
     *
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.serialNumber 流水号
     * @apiSuccess {String} data.outsideSerialNumber 外部流水号
     * @apiSuccess {Integer} data.transactionResult 交易结果
     * <table><tr><th>交易结果</th><th>描述</th></tr><tr><td>1</td><td>交易完成</td></tr><tr><td>2</td><td>待处理</td></tr><tr><td>3</td><td>交易失败</td></tr><tr><td>4</td><td>交易不存在</td></tr></table>
     * @apiSuccess {Integer} data.transactionType 交易类型
     * <table><tr><th>交易类型</th><th>描述</th></tr><tr><td>1</td><td>充值</td></tr><tr><td>2</td><td>提现</td></tr><tr><td>3</td><td>转账</td></tr></table>
     * @apiSuccess {String} data.transactionTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.transactionTimestamp 交易时间戳
     * @apiSuccess {String} data.transactionHash 交易哈希
     * @apiSuccess {String} data.transferOut 出账方
     * @apiSuccess {String} data.transferInto 入账方
     * @apiSuccess {String} data.assetCode 交易资产缩写
     * @apiSuccess {BigDecimal} data.assetAmt 金额
     * @apiSuccess {BigDecimal} data.handlingFee 手续费
     * @apiSuccess {String} data.transactionNetwork 交易网络
     * @apiSuccess {String} data.blockHash 区块哈希
     * @apiSuccess {BigDecimal} data.blockHeight 区块高度
     * @apiSuccess {BigDecimal} data.blockTime 区块时间戳
     *
     */
    public ServiceCall<BaseResponse.TransactionsResponse> transactions(TransactionRequest transactionRequest) {
        String[] pathSegments = {BASE_URL, "getTransactionList"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .query("assetCode", transactionRequest.getAssetCode(), "payAccount", transactionRequest.getPayAccount()
                        , "endDate", transactionRequest.getEndDate(), "limit", transactionRequest.getLimit()
                        , "startDate", transactionRequest.getStartDate(), "tranType", transactionRequest.getTranType());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransactionsResponse.class));
    }

    /**
     * @api DaexWalletApiClient.transfer(TransferRequest.class) 转账
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     *
     * @apiParam {String} payAccount 付款账户
     * @apiParam {String=1} payPattern 付款模式
     * <table><tr><th>付款模式</th><th>描述</th></tr><tr><td>1</td><td>单笔</td></tr></table>
     * @apiParam {String} assetCode 付款资产，币种缩写
     * @apiParam {String} receAccount 收款人账户
     * @apiParam {String} payAmount 付款金额
     * @apiParam {String} payTime 付款时间
     * @apiParam {String} outNumber 外部流水号
     * @apiParam {String} [isShare] 是否分润（暂时不提供该功能）
     * @apiParam {String} [shareAccounts] 分润账户集（暂时不提供该功能）
     * @apiParam {String} [remark] 备注
     *
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.bizNumber 转账流水号
     * @apiSuccess {String} data.outNumber 外部流水号
     * @apiSuccess {String} data.status 转账结果
     * <table><tr><th>转账结果</th><th>描述</th></tr><tr><td>1</td><td>申请</td></tr><tr><td>2</td><td>提现完成</td></tr><tr><td>3</td><td>提现失败</td></tr><tr><td>4</td><td>已撤销</td></tr></table>
     * @apiSuccess {String} data.accountAmount 账户余额
     * @apiSuccess {String} data.sucTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     */
    public ServiceCall<BaseResponse.TransferResponse> transfer(TransferRequest transferRequest) {
        String[] pathSegments = {BASE_URL, "transfer"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .form("assetCode", transferRequest.getAssetCode(), "payAccount", transferRequest.getPayAccount()
                        , "payPattern", transferRequest.getPayPattern(), "receAccount", transferRequest.getReceAccount()
                        , "payAmount", transferRequest.getPayAmount(), "payTime", transferRequest.getPayTime()
                        , "isShare", transferRequest.getIsShare(), "share", transferRequest.getShareAccounts()
                        , "outNumber", transferRequest.getOutNumber()
                        , "remark", transferRequest.getRemark());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.TransferResponse.class));
    }

    /**
     * @api DaexWalletApiClient.withdraw(WithdrawRequest.class) 提现
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     *
     * @apiParam {String} withdrawAccount 提现账户
     * @apiParam {String} withdrawPattern 提现模式
     * <table><tr><th>提现模式</th><th>描述</th></tr><tr><td>1</td><td>单笔</td></tr></table>
     * @apiParam {String} assetCode 提现资产，币种缩写
     * @apiParam {String} withdrawTime 提现时间
     * @apiParam {String} outNumber 外部流水号
     * @apiParam {String} withdrawAddress 提现地址
     * @apiParam {BigDecimal} withdrawAmount 提现金额
     * @apiParam {String} [remark] 备注
     * @apiParam {String} [memo] 提现标签集
     *
     *
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.bizNumber 提现流水号
     * @apiSuccess {String} data.outNumber 外部流水号
     * @apiSuccess {String} data.status 提现申请结果
     * <table><tr><th>提现申请结果</th><th>描述</th></tr><tr><td>1</td><td>申请</td></tr><tr><td>2</td><td>提现完成</td></tr><tr><td>3</td><td>提现失败</td></tr><tr><td>4</td><td>已撤销</td></tr></table>
     * @apiSuccess {String} data.sucTime 申请完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.freezeAmt 账户冻结资产
     * @apiSuccess {String} data.backURL 提现确认验证码（为param后面的数据）
     */
    public ServiceCall<BaseResponse.WithdrawResponse> withdraw(WithdrawRequest withdrawRequest) {
        String[] pathSegments = {BASE_URL, "putApply"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .form("assetCode", withdrawRequest.getAssetCode(), "payAccount", withdrawRequest.getWithdrawAccount()
                        , "payPattern", withdrawRequest.getWithdrawPattern(), "putAddress", withdrawRequest.getWithdrawAddress()
                        , "putAmount", withdrawRequest.getWithdrawAmount(), "payTime", withdrawRequest.getWithdrawTime()
                        , "outNumber", withdrawRequest.getOutNumber(), "remark", withdrawRequest.getRemark());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.WithdrawResponse.class));
    }


    /**
     * @api DaexWalletApiClient.withdrawConfirm(WithdrawRequest.class) 提现确认
     * @apiGroup Wallet
     * @apiVersion 1.0.0
     *
     * @apiParam {String} withdrawAccount 提现账户
     * @apiParam {String} withdrawPattern 提现模式
     * <table><tr><th>提现模式</th><th>描述</th></tr><tr><td>1</td><td>单笔</td></tr></table>
     * @apiParam {String} assetCode 提现资产，币种缩写
     * @apiParam {String} withdrawTime 提现时间
     * @apiParam {String} outNumber 外部流水号
     * @apiParam {String} withdrawAddress 提现地址
     * @apiParam {String} bizNumber 提现流水号
     * @apiParam {BigDecimal} withdrawAmount 提现金额
     * @apiParam {String} operation 提现操作
     * <table><tr><th>提现操作</th><th>描述</th></tr><tr><td>01</td><td>确认</td></tr><tr><td>02</td><td>撤销</td></tr></table>
     * @apiParam {String} [remark] 备注
     * @apiParam {String} [memo] 提现标签集
     *
     * @apiSuccess {String} status 请求返回状态
     * @apiSuccess {String} message 请求返回提示信息
     * @apiSuccess {Object} data 请求返回信息
     * @apiSuccess {String} data.bizNumber 提现流水号
     * @apiSuccess {String} data.outNumber 外部流水号
     * @apiSuccess {String} data.status 提现复核结果
     * <table><tr><th>提现复核结果</th><th>描述</th></tr><tr><td>1</td><td>申请</td></tr><tr><td>2</td><td>提现完成</td></tr><tr><td>3</td><td>提现失败</td></tr><tr><td>4</td><td>已撤销</td></tr></table>
     * @apiSuccess {String} data.sucTime 交易完成时间（格式：yyyy-MM-dd HH:mm:ss）
     * @apiSuccess {String} data.usableAmt 账户余额
     */
    public ServiceCall<BaseResponse.WithdrawResponse> withdrawConfirm(WithdrawRequest withdrawRequest) {
        String[] pathSegments = {BASE_URL, "putApplyConfirm"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getEndPoint(), pathSegments))
                .form("assetCode", withdrawRequest.getAssetCode(), "payAccount", withdrawRequest.getWithdrawAccount()
                        , "payPattern", withdrawRequest.getWithdrawPattern(), "putAddress", withdrawRequest.getWithdrawAddress()
                        , "putAmount", withdrawRequest.getWithdrawAmount(), "payTime", withdrawRequest.getWithdrawTime()
                        , "outNumber", withdrawRequest.getOutNumber(), "remark", withdrawRequest.getRemark()
                        , "operation", withdrawRequest.getOperation(), "bizNumber", withdrawRequest.getBizNumber());
        return createServiceCall(builder.build(), ResponseConverterUtils.getObject(BaseResponse.WithdrawResponse.class));
    }

    /**
     * @api status 状态
     * @apiGroup Status
     * @apiVersion 1.0.0
     * @apiDescription
     * <table><tr><th>status</th><th>描述</th></tr>
     * <tr><td>00000</td><td>成功</td></tr>
     * <tr><td>10001</td><td>参数不能为空</td></tr>
     * <tr><td>10002</td><td>非法参数</td></tr>
     * <tr><td>10003</td><td>重复请求</td></tr>
     * <tr><td>10004</td><td>错误的报文格式</td></tr>
     * <tr><td>20001</td><td>系统内部错误</td></tr>
     * <tr><td>20002</td><td>网络</td></tr>
     * <tr><td>30001</td><td>金额非法</td></tr>
     * <tr><td>30002</td><td>发起方账户非法</td></tr>
     * <tr><td>30003</td><td>接收方账户非法</td></tr>
     * <tr><td>30004</td><td>日期非法</td></tr>
     * <tr><td>40001</td><td>API类型不匹配</td></tr>
     * <tr><td>40002</td><td>非法API</td></tr>
     * <tr><td>40003</td><td>API提现已关闭</td></tr>
     * <tr><td>99999</td><td>无数据</td></tr></table>
     *
     */
}
