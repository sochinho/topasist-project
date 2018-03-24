package com.topasist.controller.handler;

import com.topasist.exception.InternalGithubException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({InternalGithubException.class})
    public ResponseEntity handleGitHubException(InternalGithubException e) {
        return ResponseEntity.status(e.getHttpStatus()).build();
    }
}
