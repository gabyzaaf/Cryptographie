package com.esgi.API;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger n, privateK, publicK;

    private int bitlen = 1024;

    /**
     * Create an instance that can encrypt using someone elses public key.
     */
    public RSA(BigInteger newn, BigInteger newe) {
        n = newn;
        publicK = newe;
    }

    public RSA(BigInteger newn, BigInteger newe, BigInteger newd) {
        this(newn, newe);
        privateK = newd;
    }

    /**
     * Create an instance that can both encrypt and decrypt.
     */
    public RSA(int bits) {
        bitlen = bits;
        generateKeys();
    }

    /**
     * Encrypt the given plaintext message.
     */
    public synchronized String encrypt(String message) {
        return (new BigInteger(message.getBytes())).modPow(publicK, n).toString();
    }

    /**
     * Encrypt the given plaintext message.
     */
    public synchronized BigInteger encrypt(BigInteger message) {
        return message.modPow(publicK, n);
    }

    /**
     * Decrypt the given ciphertext message.
     */
    public synchronized String decrypt(String message) {
        return new String((new BigInteger(message)).modPow(privateK, n).toByteArray());
    }

    /**
     * Decrypt the given ciphertext message.
     */
    public synchronized BigInteger decrypt(BigInteger message) {
        return message.modPow(privateK, n);
    }


    /**
     * Encrypt to transmission Serve -> Cli
     * @param message String
     * @return String
     */
    public synchronized String encryptP(String message) {
        return (new BigInteger(message.getBytes())).modPow(privateK, n).toString();
    }
    /**
     * Decrypt to transmission Cli -> Serve
     * @param message String
     * @return String
     */
    public synchronized String decryptP(String message) {
        return new String((new BigInteger(message)).modPow(publicK, n).toByteArray());
    }

    /**
     * Generate a new public and private key set.
     */
    public synchronized void generateKeys() {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
                .subtract(BigInteger.ONE));
        publicK = new BigInteger("3");
        while (m.gcd(publicK).intValue() > 1) {
            publicK = publicK.add(new BigInteger("2"));
        }
        privateK = publicK.modInverse(m);
    }

    /**
     * Return the modulus.
     */
    public synchronized BigInteger getN() {
        return n;
    }

    /**
     * Return the public key.
     */
    public synchronized BigInteger getPublicK() {
        return publicK;
    }

    /**
     * Return the private key.
     */
    public synchronized BigInteger getPrivateK() {
        return privateK;
    }
}
