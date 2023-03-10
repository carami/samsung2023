package com.exam.todojpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
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
}
