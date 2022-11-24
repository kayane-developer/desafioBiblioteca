package br.com.biblioteca.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException {
	
	public NegocioException(String message) {
		super(message);
	}
}
