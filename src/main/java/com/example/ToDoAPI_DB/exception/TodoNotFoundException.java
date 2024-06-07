package com.example.ToDoAPI_DB.exception;

public class TodoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TodoNotFoundException(long todoId) {
		super("Todoコード" + todoId + "は見つかりません。");
	}

}
