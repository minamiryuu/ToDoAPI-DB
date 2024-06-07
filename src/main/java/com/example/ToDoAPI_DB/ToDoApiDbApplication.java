package com.example.ToDoAPI_DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ToDoAPI_DB.model.Todo;
import com.example.ToDoAPI_DB.repo.TodoRepository;

@SpringBootApplication
public class ToDoApiDbApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToDoApiDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		todoRepository.save(new Todo(null, "タイトル", "ステータス(未着手/進行中/完了)", "詳細"));
	}

}
