package com.chipset.dscatalog.service.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
} 