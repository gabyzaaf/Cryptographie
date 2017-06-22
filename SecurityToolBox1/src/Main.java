import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class Main {

	public static void ShouldTestRSA(){
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
	}
	
	public static void shouldTestAES(){
		final String secretKey = "cestsecret";
	     
	    String originalString = "je suis ZAZA encrypted";
	    AES aes = new AES();
	    
	    String encryptedString = null;
	    String decryptedString = null;
	    try {
			encryptedString = aes.encrypt(originalString, secretKey);
			decryptedString = aes.decrypt(encryptedString, secretKey);
			 /*System.out.println(originalString);
			 System.out.println(encryptedString);
			 System.out.println(decryptedString);*/
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	     
	   
	}
	
	public static void main(String[] args){
		String encryptedString = null;
		try {
			Scanner scanner = new Scanner(System.in);
			AES aes = new AES();
			System.out.println("Bonjour veuillez saisir votre mot de passe : ");
			String password = scanner.next();
			System.out.println("Bonjour veuillez saisir votre clée  : ");
			String key = scanner.next();
			String encryptByString = aes.encrypt(password, key);
			encryptedString = aes.readFile("fichiercode.txt");
			if(encryptByString.equals(encryptedString)){
				System.out.println("OK");
				System.out.println(aes.decrypt(encryptedString, key));
			}else{
				System.out.println("KO enryption 1 ===> "+encryptByString+" - "+encryptByString.length());
				System.out.println("KO enryption 2 ===> "+encryptedString+" - "+encryptedString.length());
			}
			//aes.decrypt(encryptedString, key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
