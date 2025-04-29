package com.chipset.dscatalog.controller.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError extends StandardError {
    private List<FieldMessage> errors = new ArrayList<>();

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
} 