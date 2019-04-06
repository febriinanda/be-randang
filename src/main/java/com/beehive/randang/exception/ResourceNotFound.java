package com.beehive.randang.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SEE_OTHER)
public class ResourceNotFound extends RuntimeException {
    private static final String MESSAGE_DEFAULT = "Resource that you are looking for is not really exist";
    public ResourceNotFound() {
        super(MESSAGE_DEFAULT);
    }

    public ResourceNotFound(String message) {
        super(getProperMessage(message));
    }

    private static String getProperMessage(String message) {
        return "This "+message+" is not exist";
    }
}
