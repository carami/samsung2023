package com.exam.todojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		return todoRepository.findAll(Sort.by("id").descending());
	}
	
	@Transactional(readOnly = true)
	public Todo getTodo(Long id) {
		return todoRepository.findById(id).get();
	}
	
	@Transactional
	public Todo addTodo(String todo) {
		Todo insertTodo = new Todo();
		insertTodo.setTodo(todo);
		
		return todoRepository.save(insertTodo);
		
		
	}
	
	@Transactional
	public Todo updateTodo(Long id) {
		System.out.println("service updateTodo 메소드 시작!!");
		Todo findTodo = null;
		try {
			findTodo = todoRepository.findById(id).orElseThrow();
			
			findTodo.setDone(!findTodo.isDone());
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("service updateTodo 메소드 끝!!");
		}
		return findTodo;
	}
	
	@Transactional
	public void deleteTodo(Long id) {
		Optional<Todo> result =	todoRepository.findById(id);
		if(result.isEmpty())
			return;
		todoRepository.delete(result.get());
	}
}
