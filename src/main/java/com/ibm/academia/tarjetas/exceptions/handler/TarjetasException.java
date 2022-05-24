package com.ibm.academia.tarjetas.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.academia.tarjetas.exceptions.BadRequestException;
import com.ibm.academia.tarjetas.exceptions.NotFoundException;

@ControllerAdvice
public class TarjetasException 
{
	
	 @ExceptionHandler(value = BadRequestException.class)
	    public ResponseEntity<Object> formatoInvalidoException(BadRequestException exception)
	    {
	        Map<String, Object> respuesta = new HashMap<String, Object>();
	        respuesta.put("error", exception.getMessage());
	        return  new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(value = NotFoundException.class)
	    public ResponseEntity<?> noExisteException(NotFoundException exception)
	    {
	        Map<String, Object> respuesta = new HashMap<String, Object>();
	        respuesta.put("error", exception.getMessage());
	        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
	    }

}
