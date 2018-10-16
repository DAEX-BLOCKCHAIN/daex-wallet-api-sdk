package io.daex.api.wallet.sdk.v1.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by qingyun.yu on 2018/7/31.
 */
public class SecurityUtil {

    public static String encoderByMD5(String content) {
        if(StringUtils.isBlank(content)) {
            return "";
        }
        MessageDigest md5Digest = null;
        try {
            md5Digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
        md5Digest.update(content.getBytes());
        return new BigInteger(1, md5Digest.digest()).toString(16);
    }
}
