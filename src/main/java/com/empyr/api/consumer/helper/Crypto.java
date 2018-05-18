package com.empyr.api.consumer.helper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

/**
 * Created by markzipagang on 5/18/18.
 */
public class Crypto {
    private static final String HMAC_SHA512 = "HmacSHA512";
    private static final String HMAC_SHA256 = "HmacSHA256";

    public static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    public static byte[] calculateHMACSHA512(String data, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
        return calculateHMAC(data, key, HMAC_SHA512);
    }

    public static byte[] calculateHMACSHA256(String data, String key)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
        return calculateHMAC(data, key, HMAC_SHA256);
    }

    private static byte[] calculateHMAC(String data, String key, String algo)
            throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
    {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algo);
        Mac mac = Mac.getInstance(algo);
        mac.init(secretKeySpec);
        return mac.doFinal(data.getBytes());
    }
}
