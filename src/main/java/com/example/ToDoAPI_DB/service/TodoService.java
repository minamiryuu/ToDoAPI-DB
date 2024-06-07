package com.example.ToDoAPI_DB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoAPI_DB.model.Todo;
import com.example.ToDoAPI_DB.repo.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository itemRepository;

	public List<Todo> getAllTodos() {
		List<Todo> allTodos = new ArrayList<>();
		itemRepository.findAll().forEach(allTodos::add);
		return allTodos;
	}

	public Optional<String> getTodoDetails(Long todoId) {
		Optional<Todo> todoOptional = itemRepository.findById(todoId);
		return todoOptional.map(Todo::getDetails);
	}

	public List<Todo> getSameStatusTodos(String status) {
		List<Todo> subTodos = new ArrayList<>();
		itemRepository.findAllByStatus(status).forEach(subTodos::add);
		return subTodos;
	}

	public void addTodo(Todo todo) {
		itemRepository.save(todo);
	}

	public Optional<Todo> getTodo(Long todoId) {
		return itemRepository.findById(todoId);
	}

	public void updateTodo(Long todoId, Todo todo) {
		if (itemRepository.findById(todoId).get() != null) {
			itemRepository.save(todo);
		}
	}

	public void deleteTodo(Long todoId) {
		itemRepository.deleteById(todoId);
	}

}
