package com.exam.todomvc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todomvc.config.ApplicationConfig;
import com.exam.todomvc.dao.TodoDao;
import com.exam.todomvc.domain.Todo;

public class TodoDaoRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoDao dao = context.getBean(TodoDao.class);
		
//		int resultCount = dao.insertTodo("걷기!!");
//		System.out.println(resultCount);
		
		
//		dao.deleteTodo(1L);
		
//		Todo updateTodo = new Todo();
//		updateTodo.setId(2L);
//		updateTodo.setDone(true);
//		
//		dao.updateTodo(updateTodo);
//		
//		List<Todo> todos =dao.getTodos();
//		
//		for (Todo todo : todos) {
//			System.out.println(todo);
//		}
		
//		Todo todo = dao.getTodo(3L);
//		System.out.println(todo);
		
		Todo todo = 	dao.addTodo("test");
		System.out.println(todo);
	}

}
