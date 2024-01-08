package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Quando a solicitação não pode ser completada devido a um conflito de estado.
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5496003792165703924L;

    public ConflictException(String message) {
        super(message);
    }
}
    