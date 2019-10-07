package hu.flowacademy.test.foodorder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidationException extends  RuntimeException{

    private ResponseStatusException BAD_REQ = new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");

    public ValidationException(String message) {
        super(message);
        throw BAD_REQ;
    }
}
