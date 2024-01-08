package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/**
 * Quando a solicitação não pode ser processada devido a parâmetros inválidos ou falta de campos obrigatórios.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8356313341427220008L;

    public InvalidRequestException(String message) {
        super(message);
    }
}
    