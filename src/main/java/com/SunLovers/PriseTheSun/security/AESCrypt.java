package com.SunLovers.PriseTheSun.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESCrypt {
    
    private static final String AES = "AES";
    private static final byte[] SECRET_KEY = "ChaveSecreta1234".getBytes(StandardCharsets.UTF_8);
    public static byte[] encrypt(String plainText) throws Exception {
        Key secretKey = new SecretKeySpec(SECRET_KEY, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        System.out.println(plainText);
        byte[] criptado = cipher.doFinal(plainText.getBytes());
        System.out.println(criptado);
        return  criptado;
    }

    public static String decrypt(byte[] encryptedText) throws Exception {
        Key secretKey = new SecretKeySpec(SECRET_KEY, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedTextBytes = cipher.doFinal(encryptedText);
        return new String(decryptedTextBytes);
    }

}
