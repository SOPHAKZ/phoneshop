package com.java.spring.boot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@SuppressWarnings("serial")
@Data

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>{
	private HttpStatus status;
	private String message;
}
