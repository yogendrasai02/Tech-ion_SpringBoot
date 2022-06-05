package com.techion.techion.error;

import com.techion.techion.entity.GeneralError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// refer https://www.baeldung.com/exception-handling-for-rest-with-spring
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // return a 404 error
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<GeneralError> handleProductNotFoundException(ProductNotFoundException productNotFoundException, WebRequest webRequest) {
        GeneralError error = new GeneralError(HttpStatus.NOT_FOUND, productNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
