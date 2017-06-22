package com.crypto.securityToolBox.com.crypto.securityTool;


import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

public class RSA {
    private static KeyPair keyPair;
    private static KeyPair keyPairCli;
    private static int keySize = 1024;

    public RSA() {
        this(keySize);
    }

    public RSA(int _keySize) {
        keySize = _keySize;
        try {
            keyPair = buildKeyPair();
            keyPairCli = buildKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public BigInteger getPublicKey() {
        RSAPublicKey pubKey = (RSAPublicKey) keyPair.getPublic();
        return pubKey.getModulus();
    }

    public BigInteger getPrivateKeyToCli() {
        RSAPrivateKey privKey = (RSAPrivateKey) keyPair.getPrivate();
        return privKey.getModulus();
    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    /**
     *
     * @param privateKey PrivateKey
     * @param message String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(message.getBytes());
    }

    /**
     *
     * @param publicKey PublicKey
     * @param encrypted byte[]
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(encrypted);
    }
}