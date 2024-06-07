package com.example.ToDoAPI_DB.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ToDoAPI_DB.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

	Iterable<Todo> findAllByStatus(String status);

}
