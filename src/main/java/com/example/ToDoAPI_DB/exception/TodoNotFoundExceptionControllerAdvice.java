package com.example.ToDoAPI_DB.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TodoNotFoundExceptionControllerAdvice {

	@ResponseBody
	@ExceptionHandler(TodoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String TodoNotFoundHandler(TodoNotFoundException ex) {
		return ex.getMessage();
	}

}
