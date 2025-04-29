package com.chipset.dscatalog.service.exception;

import lombok.Getter;

@Getter
public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DatabaseException(String message) {
        super(message);
    }
} 