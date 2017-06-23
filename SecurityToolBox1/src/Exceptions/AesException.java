package Exceptions;

import org.apache.log4j.Logger;

public class AesException extends Exception{

	final static Logger logger = Logger.getLogger(AesException.class);
	public AesException(String message){
		super(message);
		logger.error(message);
	}
	
}
