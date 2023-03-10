package com.exam.todojpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;
import com.exam.todojpa.service.TodoService;

public class JpaRun {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoRepository todoRepo = 	context.getBean(TodoRepository.class);
		
		//1. 저장 
//		Todo todo = new Todo();
//		todo.setTodo("spring jpa 연습하기!!");
//		
//		todo = todoRepo.save(todo);
//		System.out.println(todo);
		
		//2. 한건 조회 
//		Todo resultTodo = todoRepo.findById(1L).orElseThrow();
//		System.out.println(resultTodo);
		
		//3. 여러건 조회 
		List<Todo> todos = null;
		
//		todos = todoRepo.findAll();   //전체조회    
		
//		Pageable pageable = PageRequest.of(0, 3,Sort.by("todo").descending());
//		todos = todoRepo.findAll(pageable).getContent();
//		
//		for (Todo todo : todos) {
//			System.out.println(todo);
//		}
		
		//수정
		TodoService service = context.getBean(TodoService.class);
		System.out.println("service 시작전");
		Todo updateTodo = service.updateTodo(2L);
		System.out.println("service 종료");
	}

}
