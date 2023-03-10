package com.exam.todojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
	@Autowired
	private TodoService todoService;

	
	@GetMapping
	public List<Todo> getTodos() {
		
		List<Todo> todos =todoService.getTodos();
		return todos;
	}
	
	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable("id")Long id) {
		return todoService.getTodo(id);
	}
	
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo.getTodo());
	}
	@DeleteMapping
	public String deleteTodo(@RequestBody Todo todo) {
		todoService.deleteTodo(todo.getId());
		return "ok!!";
	}
	
	@PatchMapping
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo.getId());
	}
}
