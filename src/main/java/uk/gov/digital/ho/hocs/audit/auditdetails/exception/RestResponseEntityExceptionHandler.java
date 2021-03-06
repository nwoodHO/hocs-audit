package uk.gov.digital.ho.hocs.audit.auditdetails.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(EntityCreationException.class)
    public ResponseEntity handle(EntityCreationException e) {
        log.error("EntityCreationException: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handle(EntityNotFoundException e) {
        log.error("EntityNotFoundException: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), NOT_FOUND);
    }

}
