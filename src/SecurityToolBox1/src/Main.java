
package SecurityToolBox1.src;


import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.math.BigInteger;

import Exceptions.RsaException;

public class Main {

	
	
	public static void main(String[] args){
		
		if(args[0].equalsIgnoreCase("--help") || args[0].equalsIgnoreCase("-h")){
			System.out.println("La documentation est présent ici : https://github.com/gabyzaaf/Cryptographie/blob/master/SecurityToolBox1/documentation/start.md \n");
			System.out.println("1. Vous devez generer le fichier ayant la clee (fichier.key). \n Ce fichier sera à la place au meme endroit que votre fichier jar. \n"
					+ "2. Vous devez ajouter je fichier jar dans votre IDE pour beneficier des fonctionnalités \n"
					+ "3. Il existe 3 types de librairie (Hashage,AES,RSA)");
		}else{
		
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
		}
		
		
		
	}
	
}