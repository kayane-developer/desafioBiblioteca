package br.com.biblioteca.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class ModificacaoException extends RuntimeException {
	public ModificacaoException(String message) {
		super(message);
	}

}
