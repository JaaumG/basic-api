package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Quando uma operação excede o tempo limite esperado.
 */
@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
public class TimeoutException extends RuntimeException {

    public TimeoutException(String message) {
        super(message);
    }

}
    