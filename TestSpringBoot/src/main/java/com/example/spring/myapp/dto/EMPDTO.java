package com.example.spring.myapp.dto;

import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Repository
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class EMPDTO extends BaseDto{
	public String empno ;
	public String name;
	public String hpno;
	public String email;
}
