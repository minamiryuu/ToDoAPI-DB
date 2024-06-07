package com.example.ToDoAPI_DB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; // 追加

@Data
@AllArgsConstructor
@NoArgsConstructor // 追加
@Entity(name = "m_item")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String status;
	private String details;
}
