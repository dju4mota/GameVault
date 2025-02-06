package octodevs.gamevault.config;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity BadArgument(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getFieldErrors().stream().map(ValidationError::new).toList());
    }


    private record ValidationError(String field, String message) {

        ValidationError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
