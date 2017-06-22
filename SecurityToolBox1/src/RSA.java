import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger n, d, e;

    private int bitlen = 1024;

    /**
     * Create an instance that can encrypt using someone elses public key.
     */
    public RSA(BigInteger newn, BigInteger newe) {
        n = newn;
        e = newe;
    }

    /**
     * Create an instance that can both encrypt and decrypt.
     */
    public RSA(int bits) {
        bitlen = bits;
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
                .subtract(BigInteger.ONE));
        e = new BigInteger("3");
        while (m.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        d = e.modInverse(m);
    }

    /**
     * Encrypt the given plaintext message.
     */
    public synchronized String encrypt(String message) {
        return (new BigInteger(message.getBytes())).modPow(e, n).toString();
    }

    /**
     * Encrypt the given plaintext message.
     */
    public synchronized BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public byte[] encrypt(byte[] image) {
        byte[] encryptedImage = new byte[image.length];
        for (int i =0 ; i< image.length; i++){
            encryptedImage[i]= (BigInteger.valueOf(image[i])).modPow(e, n).byteValue();

        }
        return encryptedImage;
    }

    public byte[] decrypt(byte[] image) {
        byte[] decryptedImage = new byte[image.length];
        System.out.println("decrypt - init : --Size : " + image.length );
        for (int i =0 ; i< image.length; i++){
            decryptedImage[i]= (BigInteger.valueOf(image[i])).modPow(d, n).byteValue();
            if(0 == i%100)
                System.out.println("decrypt - run : --Size pasted : " + (i/image.length) + "%" );

        }

        return decryptedImage;

    }

    /**
     * Decrypt the given ciphertext message.
     */
    public synchronized String decrypt(String message) {
        return new String((new BigInteger(message)).modPow(d, n).toByteArray());
    }

    /**
     * Decrypt the given ciphertext message.
     */
    public synchronized BigInteger decrypt(BigInteger message) {
        return message.modPow(d, n);
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
        e = new BigInteger("3");
        while (m.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        d = e.modInverse(m);
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
    public synchronized BigInteger getE() {
        return e;
    }

}
