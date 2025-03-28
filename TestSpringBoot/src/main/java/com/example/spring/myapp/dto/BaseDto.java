package com.example.spring.myapp.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BaseDto {
    private String _status;
    private String sysId;
    private String langCd;
    private String langData;

    private String crtUserId;
    private String crtDt;
    private String chgUserId;
    private String chgDt;

    private String saveUserId;
}

