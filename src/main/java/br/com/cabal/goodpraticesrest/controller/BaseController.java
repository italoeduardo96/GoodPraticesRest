package br.com.cabal.goodpraticesrest.controller;

import br.com.cabal.goodpraticesrest.exception.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    protected ResponseEntity<?> buildResponseEntity(Object object, HttpStatus status) {
        return new ResponseEntity<>(object, status);
    }

    protected ResponseEntity<?> buildResponseEntity( Object object) {
        return ResponseEntity.ok(object);
    }

    protected ResponseEntity<?> buildResponseEntity( HttpStatus status) {
        return ResponseEntity.status(status).build();
    }
}
