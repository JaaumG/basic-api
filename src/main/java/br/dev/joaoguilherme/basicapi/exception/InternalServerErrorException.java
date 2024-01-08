package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Para casos não esperados que resultem em um erro interno do servidor.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 553860816592886342L;

    public InternalServerErrorException(String message) {
        super(message);
    }
}
    