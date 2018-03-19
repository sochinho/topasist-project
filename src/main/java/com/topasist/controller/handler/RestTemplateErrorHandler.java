package com.topasist.controller.handler;

import com.topasist.exception.InternalGithubException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@Slf4j
public class RestTemplateErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        log.error("Error from GitHub server");

        throw new InternalGithubException(response.getStatusCode());
    }
}
