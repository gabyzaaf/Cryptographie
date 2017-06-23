package Exceptions;

import org.apache.log4j.Logger;

public class RsaException extends Exception {

	final static Logger logger = Logger.getLogger(RsaException.class);
	
	public RsaException(String message){
		super(message);
		logger.error(message);
	}
}
