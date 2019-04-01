package io.piano.test.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {

    protected static final Log LOG = LogFactory.getLog(GeneralExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    ResponseEntity<Object> handleBadRequest(Exception ex) {
        LOG.error("Error while processing request", ex);
        return new ResponseEntity<>(
                "Error while processing request: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
