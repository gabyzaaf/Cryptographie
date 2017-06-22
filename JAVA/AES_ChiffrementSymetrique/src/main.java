
public class main {
	public static void main(String[] args) 
	{
	    final String secretKey = "cestsecret";
	     
	    String originalString = "je suis un message encrypt";
	    String encryptedString = AES.encrypt(originalString, secretKey) ;
	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
	     
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	}

}
