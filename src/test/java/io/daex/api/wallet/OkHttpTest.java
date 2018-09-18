package io.daex.api.wallet;

import io.daex.api.wallet.sdk.v1.enums.StatusType;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by qingyun.yu on 2018/9/11.
 */
public class OkHttpTest {

    private static OkHttpClient mOkHttpClient;

    static {
        okhttp3.OkHttpClient.Builder ClientBuilder=new okhttp3.OkHttpClient.Builder();
        ClientBuilder.readTimeout(20, TimeUnit.SECONDS);//读取超时
        ClientBuilder.connectTimeout(6, TimeUnit.SECONDS);//连接超时
        ClientBuilder.writeTimeout(60, TimeUnit.SECONDS);//写入超时
        mOkHttpClient=ClientBuilder.build();
    }
    @Test
    public void testPost() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("payPattern", "2");
        paramMap.put("assetCode", "DAX");
        paramMap.put("receAccount", "bibibiBI2Davis");
        paramMap.put("payAmount", "10001000");
        paramMap.put("outNumber", "wb1234567");
        paramMap.put("remark", "00f9011f-c3c9-47ff-9b37-d1290d0bf8a7:ZpIwHiBIiUqfSHx8VIoItd08zzPN/z38gZoIZMB4ULHQ1XBiD5VFL7leu2RDh7m+tLAZi9/VabI8NwalvvmIoduShu4KOff/Nud6HuquUgunOzWV5bAlusO0RETmiykVKIgfki7MOyBJt9EqIJmo1wH6WSXw2K4I/iRIbdrqTzqhXuLFtXiR2xpK9xkGso40RggieYbcy97zMYDERGMh1KtRN1+brkN01B8Gyesx70Njao2UUl82M7XQcmzt7d3vLcWOigiJjb12D5rp+LfulxFHJ4YVPa9DK4bx+yqnA1eNy2cWCSbYf1KZeEy1TL5dRFSgA6Z4h8GnEFmPB104Ag==00f9011f-c3c9-47ff-9b37-d1290d0bf8a7:ZpIwHiBIiUqfSHx8VIoItd08zzPN/z38gZoIZMB4ULHQ1XBiD5VFL7leu2RDh7m+tLAZi9/VabI8NwalvvmIoduShu4KOff/Nud6HuquUgunOzWV5bAlusO0RETmiykVKIgfki7MOyBJt9EqIJmo1wH6WSXw2K4I/iRIbdrqTzqhXuLFtXiR2xpK9xkGso40RggieYbcy97zMYDERGMh1KtRN1+brkN01B8Gyesx70Njao2UUl82M7XQcmzt7d3vLcWOigiJjb12D5rp+LfulxFHJ4YVPa9DK4bx+yqnA1eNy2cWCSbYf1KZeEy1TL5dRFSgA6Z4h8GnEFmPB104Ag==bbbbbbbbbbsssssssssssssssssss");
        paramMap.put("payAccount", "yuqingyun@daex.io");
        postDataSynToNet("http://172.18.0.97:5000/api/service/transfer", paramMap);
    }


    public static Response postDataSynToNet(String url, Map<String,String> bodyParams) {
        //1构造RequestBody
        RequestBody body=setRequestBody(bodyParams);
        //2 构造Request
        Request.Builder requestBuilder = new Request.Builder();
        Request request = requestBuilder.post(body).url(url).build();
        //3 将Request封装为Call
        Call call = mOkHttpClient.newCall(request);
        //4 执行Call，得到response
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    private static RequestBody setRequestBody(Map<String, String> BodyParams){
        RequestBody body=null;
        okhttp3.FormBody.Builder formEncodingBuilder=new okhttp3.FormBody.Builder();
        if(BodyParams != null){
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next().toString();
                formEncodingBuilder.add(key, BodyParams.get(key));
            }
        }
        body=formEncodingBuilder.build();
        return body;

    }

    @Test
    public void testStatusType() {
        System.out.println(StatusType.statusType("00000").message());
        System.out.println(StatusType.statusType("99999").message());
    }
}
