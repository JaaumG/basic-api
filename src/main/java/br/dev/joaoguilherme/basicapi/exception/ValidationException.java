package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Para cenários de validação que não são cobertos pelas anotações de validação padrão.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5308608816383562237L;

    public ValidationException(String message) {
        super(message);
    }
}
    