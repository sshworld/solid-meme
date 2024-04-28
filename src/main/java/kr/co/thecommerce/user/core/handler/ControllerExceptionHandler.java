package kr.co.thecommerce.user.core.handler;

import java.util.HashMap;
import java.util.NoSuchElementException;
import kr.co.thecommerce.user.core.exception.ConflictException;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = NoSuchElementException.class)
    protected ResponseEntity<HashMap<String, Object>> noSuchElementExceptionHandler(NoSuchElementException exception) {
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", false);
        response.put("message", exception.getMessage());

        return new ResponseEntity<>(response, NOT_FOUND);
    }

    @ExceptionHandler(value = {IllegalStateException.class, IllegalArgumentException.class})
    protected ResponseEntity<HashMap<String, Object>> illegalExceptionHandler(RuntimeException exception) {
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", false);
        response.put("message", exception.getMessage());

        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler(value = ConflictException.class)
    protected ResponseEntity<HashMap<String, Object>> conflictExceptionHandler(ConflictException exception) {
        HashMap<String, Object> response = new HashMap<>();

        response.put("status", false);
        response.put("message", exception.getMessage());

        return new ResponseEntity<>(response, CONFLICT);
    }
}
