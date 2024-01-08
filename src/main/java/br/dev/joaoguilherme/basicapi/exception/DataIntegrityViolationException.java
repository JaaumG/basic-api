package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Quando uma operação viola a integridade dos dados.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataIntegrityViolationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8012582234682977559L;

    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
    