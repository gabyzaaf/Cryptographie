import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 











import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import Exceptions.AesException;
 
public class AES {
 
    private  SecretKeySpec secretKey;
    private  byte[] key;
    //String chaine="";
    StringBuffer buffer = new StringBuffer();
    
    public  void setKey(String myKey) throws AesException
    {
    	
        MessageDigest sha = null;
        try {
        	if(myKey == null || myKey.isEmpty()){
        		throw new AesException("La clée d'entrée est vide");
        	}
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public  String encrypt(String strToEncrypt, String secret) throws Exception 
    {
    	BufferedWriter writer = null;
    	BufferedReader br = null;
        try
        {
        	if(strToEncrypt == null || strToEncrypt.isEmpty()){
        		throw new Exception("Le message inséré est vide");
        	}
        	if(secret == null || secret.isEmpty()){
        		throw new Exception("La clée secret est vide");
        	}
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            
            //crée le fichier "fichiercode.txt" qui contient la key
            writer = new BufferedWriter(new FileWriter(new File("fichiercode.txt")));
            writer.write(Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
            writer.close();
            
            
            //consulte le fichier "fichiercode.txt" et retourn la key
            InputStream ips=new FileInputStream("fichiercode.txt"); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				buffer.append(ligne);
			}
			br.close();
			
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            throw new AesException(e.getMessage());
        }
        finally{
        	if(writer != null && br != null){
        		writer.close();
        		br.close();
        	}
        }
    }
 
    public  String decrypt(String strToDecrypt, String secret) throws Exception 
    {
        try
        {
        	if(strToDecrypt == null || strToDecrypt.isEmpty()){
        		throw new Exception("Le message inséré est vide");
        	}
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
        	throw new AesException(e.getMessage());
        }
    }
    
    private boolean stringIsNullOrEmpty(String data){
    	if(data == null || data.isEmpty()){
    		return true;
    	}
    	return false;
    }
    
    public String readFile(String pathWithFile) throws IOException, AesException{
    	String contentFile = null;
    	try(BufferedReader br = new BufferedReader(new FileReader(pathWithFile))) {
    	    StringBuilder sb = new StringBuilder();
    	    String line = br.readLine();

    	    while (line != null) {
    	        sb.append(line);
    	        line = br.readLine();
    	    }
    	    contentFile = sb.toString();
    	}
    	if(stringIsNullOrEmpty(contentFile)){
    		throw new AesException("Le contenu du fichier est vide");
    	}
    	return contentFile;
    }
}