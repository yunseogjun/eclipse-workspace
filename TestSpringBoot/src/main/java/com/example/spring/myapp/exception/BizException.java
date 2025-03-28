package com.example.spring.myapp.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BizException extends Exception {

    public BizException(String exceptionMessage) {
        super(exceptionMessage);
    }

    private static final long serialVersionUID = -7082381821039910121L;

}
