
package SecurityToolBox1.src;


import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.math.BigInteger;

import Exceptions.RsaException;

public class Main {

	
	
	public static void main(String[] args){
		/*
		String encryptedString = null;
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(System.in);
			AES aes = new AES();
			System.out.println("Bonjour veuillez saisir votre mot de passe : ");
			String password = scanner.nextLine();
			System.out.println("Bonjour veuillez saisir votre clee  : ");
			String key = scanner.nextLine();
			String encryptByString = aes.encrypt(password, key);	
			System.out.println("Votre chiffrement est present dans le fichier.key ");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(scanner != null){
				scanner.close();
			}
		}
		*/
		try {
			RSA rsa = new RSA(0);
			rsa.encrypt("hello");
		} catch (RsaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
