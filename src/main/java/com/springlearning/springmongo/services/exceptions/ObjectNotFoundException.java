package com.springlearning.springmongo.services.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String id) {
        super("Object not found. Id: " + id);
    }
}
