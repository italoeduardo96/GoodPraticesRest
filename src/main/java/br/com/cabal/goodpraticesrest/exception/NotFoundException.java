package br.com.cabal.goodpraticesrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends MyException{

    public NotFoundException(String exception) {
        super(exception);
    }

}
