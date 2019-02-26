package com.mixi.demo.infrastructure;

import com.mixi.demo.infrastructure.exception.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(assignableTypes = RestController.class)
public class AbstractController {
    protected final Logger CONTROLLER_LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected Environment env;

    @ExceptionHandler
    public ResponseEntity<String> handle(DomainException ex) {
        CONTROLLER_LOGGER.info("exception: exCode {}, exMessage {}", ex.getErrorCode(), ex.getErrorResponse());
        return ResponseEntity.status(500).body(JsonUtils.toJson(ex.getErrorResponse()));
    }
}
