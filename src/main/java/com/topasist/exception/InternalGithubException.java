package com.topasist.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InternalGithubException extends RuntimeException {

    private HttpStatus httpStatus;

    public InternalGithubException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
