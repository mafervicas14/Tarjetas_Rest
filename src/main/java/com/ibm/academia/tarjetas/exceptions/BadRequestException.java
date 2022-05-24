package com.ibm.academia.tarjetas.exceptions;

public class BadRequestException extends  RuntimeException
{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1761109847991388785L;

	public  BadRequestException(String message){
	        super(message);
	    }

}
