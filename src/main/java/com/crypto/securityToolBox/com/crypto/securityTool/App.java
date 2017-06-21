package com.crypto.securityToolBox.com.crypto.securityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String text = "Hello World!";
        System.out.println( "Hello World!" );


        RSA rsa = new RSA(512);
        String message;
        System.out.println( "------ENCRYPT------" );
        System.out.println( message = rsa.encrypt(text) );
        System.out.println( "------DZCRYPT------" );
        System.out.println( rsa.decrypt(message) );

        System.out.println( "------PUBLIC KEY------" );
        System.out.println(rsa.getE());
        System.out.println( "------MODULUS------" );
        System.out.println(rsa.getN());


        System.out.println( "-------------------" );
        System.out.println( "-------RETEST------" );

        String text1 = "Yellow and Black Border Collies";
        System.out.println("Plaintext: " + text1);
        BigInteger plaintext = new BigInteger(text1.getBytes());

        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);
        plaintext = rsa.decrypt(ciphertext);

        String text2 = new String(plaintext.toByteArray());
        System.out.println("Plaintext: " + text2);

        try {
            testFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testFile() throws IOException {
        //text file, should be opening in default text editor

        BufferedImage img = null;
        img = ImageIO.read(new File("/home/nicop/Pictures/nier_automata-yorha-2b-fighting-(1282).jpg"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( img, "jpg", baos );
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();

        RSA rsa = new RSA(512);
        System.out.println("Image: " + img);
        System.out.println("Image-BYTE: " + imageInByte);
        byte[] imgEC = rsa.encrypt(imageInByte);
        System.out.println("Image-encrypt: " + imgEC);
        byte[] imgDC = rsa.decrypt(imgEC);
        System.out.println("Image-decrypt: " + imgDC);
        System.out.println("Image-decrypt: " );
//        File file = new File("/home/nicop/Pictures/nier_automata-yorha-2b-fighting-(1282).jpg");
//        //first check if Desktop is supported by Platform or not
//        if(!Desktop.isDesktopSupported()){
//            System.out.println("Desktop is not supported");
//            return;
//        }
//
//        Desktop desktop = Desktop.getDesktop();
//        if(file.exists()) desktop.open(file);

//        //let's try to open PDF file
//        file = new File("/Users/pankaj/java.pdf");
//        if(file.exists()) desktop.open(file);
    }
}
