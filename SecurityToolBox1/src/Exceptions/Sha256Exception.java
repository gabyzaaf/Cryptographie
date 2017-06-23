package Exceptions;

import org.apache.log4j.Logger;

public class Sha256Exception extends Exception {

	final static Logger logger = Logger.getLogger(Sha256Exception.class);
	
	public Sha256Exception(String message){
		super(message);
		logger.error(message);
	}
	
}
