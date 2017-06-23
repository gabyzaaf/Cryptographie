package SecurityToolBox1.src;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Exceptions.Sha256Exception;

public class Sha {

	public String createTheHashFromString(String message)throws  Exception, NoSuchAlgorithmException{
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			if(message == null || message.isEmpty()){
				throw new Sha256Exception("The message is empty");
			}
			messageDigest.update(message.getBytes());
			byte transformMessageInData[] = messageDigest.digest();
			StringBuffer stringWithFinalMessage = new StringBuffer();
			for(int i = 0;i< transformMessageInData.length;i++){
				stringWithFinalMessage.append(Integer.toString((transformMessageInData[i] & 0xff)+ 0x100,16).substring(1));
			}
			return stringWithFinalMessage.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	public  String createTheHashFromFile(String pathFile) throws Exception{
		FileInputStream fis = null;
		try {
			if(pathFile == null || pathFile.isEmpty()){
				throw new Sha256Exception("The file path is empty");
			}
			File file = new File(pathFile);
			if(!file.exists()){
				throw new Sha256Exception("The file not exist in the specific path : "+pathFile);
			}
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
	        fis = new FileInputStream(pathFile);

	        byte[] dataBytesArray = new byte[1024];

	        int readNumber = 0;
	        while ((readNumber = fis.read(dataBytesArray)) != -1) {
	        	messageDigest.update(dataBytesArray, 0, readNumber);
	        }
	        byte[] mdbytes = messageDigest.digest();
	        StringBuffer buffer = new StringBuffer();
	        for (int i = 0; i < mdbytes.length; i++) {
	        	buffer.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw e;
		}finally{
			if(fis != null){
				fis.close();
			}
		}
	}
	
}

