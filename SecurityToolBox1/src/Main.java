import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;


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
	     
	    String originalString = "je suis ZAZA encrypt";
	    AES aes = new AES();
	    
	    String encryptedString = null;
	    String decryptedString = null;
	    try {
			encryptedString = aes.encrypt(originalString, secretKey);
			decryptedString = aes.decrypt(encryptedString, secretKey);
			 System.out.println(originalString);
			 System.out.println(encryptedString);
			 System.out.println(decryptedString);
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	     
	   
	}
	
	public static void main(String[] args){
		try {
			Sha sha256 = new Sha();
			System.out.println(sha256.createTheHashFromString("Gabriel"));
			System.out.println(sha256.createTheHashFromFile("C:\\Users\\CLAPERT\\Documents\\workstation\\SecurityToolBox\\mdp.txt"));
			shouldTestAES();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
