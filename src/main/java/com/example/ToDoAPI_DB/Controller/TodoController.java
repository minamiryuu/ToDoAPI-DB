package com.example.ToDoAPI_DB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoAPI_DB.exception.TodoNotFoundException;
import com.example.ToDoAPI_DB.model.Todo;
import com.example.ToDoAPI_DB.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/todos")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@GetMapping("/todos/getdetails/{todoId}")
	public String getTodoDetails(@PathVariable("todoId") Long todoId) {
		return todoService.getTodoDetails(todoId).orElseThrow(() -> new TodoNotFoundException(todoId));
	}

	@GetMapping("/todos/FindByStatus")
	public List<Todo> getSameStatusTodos(@RequestParam("status") String status) {
		return todoService.getSameStatusTodos(status);
	}

	@PostMapping("/todos")
	public void addTodo(@RequestBody Todo todo) {
		todoService.addTodo(todo);
	}

	@GetMapping("/todos/{todoId}")
	public Todo getTodo(@PathVariable("todoId") Long todoId) {
		return todoService.getTodo(todoId).orElseThrow(() -> new TodoNotFoundException(todoId));
	}

	@PutMapping("/todos/{todoId}")
	public void putTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo Todo) {
		todoService.updateTodo(todoId, Todo);
	}

	@DeleteMapping("/todos/{todoId}")
	public void deleteTodo(@PathVariable("todoId") Long todoId) {
		todoService.deleteTodo(todoId);
	}

}
