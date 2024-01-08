package br.dev.joaoguilherme.basicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(String entityName, Number id) {
        super(entityName + " com ID " + id + " não encontrado.");
    }

    public NotFoundException(String entityName, String id) {
        super(entityName + " com ID " + id + " não encontrado.");
    }

    public NotFoundException(String entityName, UUID id) {
        super(entityName + " com ID " + id.toString() + " não encontrado.");
    }

    public NotFoundException(String message) {
        super(message);
    }

}
