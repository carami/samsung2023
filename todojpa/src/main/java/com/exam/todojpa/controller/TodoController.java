package com.exam.todojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping("/list")
	public String getTodo(Model model) {
		List<Todo> todos =	todoService.getTodos();
		
		model.addAttribute("todoList",todos);
		
		return "list";
	}
	
	@GetMapping("/update")
	public String updateTodo(@RequestParam("id")Long id) {
		
		todoService.updateTodo(id);
		
		return "redirect:/todo/list";
	}
	@GetMapping("/delete")
	public String deleteTodo(Long id) {
		todoService.deleteTodo(id);
		return "redirect:/todo/list";
	}
	
	@PostMapping("/add")
	public String addTodo(@RequestParam("todo")String todo) {
		todoService.addTodo(todo);
		return "redirect:/todo/list";
	}
}
