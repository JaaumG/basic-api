package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Quando uma operação excede o tempo limite esperado.
 */
@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
public class TimeoutException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -6119758018472023582L;

    public TimeoutException(String message) {
        super(message);
    }
}
    