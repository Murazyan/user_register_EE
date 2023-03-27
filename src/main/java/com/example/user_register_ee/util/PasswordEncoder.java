package com.example.user_register_ee.util;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class PasswordEncoder {

    private static final String KEY = "asdfer1235678941";

    @SneakyThrows
    public static String encrypt(String originalString)  {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());
        return new String(encryptedBytes);
    }
    @SneakyThrows
    private static String decrypt(byte[] encryptedBytes)  {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }


    public static boolean isMatch(String original, String encrypted){
        String originalFromDb = decrypt(encrypted.getBytes());
        return originalFromDb.equals(original);
    }
}
