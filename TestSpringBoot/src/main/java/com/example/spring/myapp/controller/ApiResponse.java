package com.example.spring.myapp.controller;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponse {

    private String code;
    private String message;

    // API 응답 결과
    private Map<String, Object> data;

    @Builder
    public ApiResponse(final String code, final String message, Map<String, Object> data, Object dataResult) {
        this.data = data;
        this.code = (code == null ? "00" : code);
        this.message = (message == null ? "" : message);
        if (this.data == null && dataResult != null) {
            this.data = new HashMap<>();
            this.data.put("result", dataResult);
        }
    }
}
