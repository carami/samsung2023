package kr.co.samsung;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.samsung.todomvc.config.ApplicationConfig;


public class SpringJDBCRun {

	public static void main(String[] args) {
		System.out.println("ApplicationContext 생성전!!");
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		System.out.println("ApplicationContext 생성후!!");
		
//		TodoDao dao = context.getBean(TodoDao.class);
		
//		List<Todo> todos = dao.getTodos();
//		
//		for (Todo todo : todos) {
//			System.out.println(todo);
//		}
//		
//		System.out.println("============== getTodo(2)");
//		
//		System.out.println(dao.getTodo(2L));
//		
//		
//		Todo updateTodo = new Todo();
//		updateTodo.setId(1L);
//		updateTodo.setDone(true);
//		
//		int resultCount = dao.updateTodo(updateTodo);
//		System.out.println(resultCount+"건 수정 완료!!");
//		
//		
//		dao.insertTodo("test");
		
//		Todo todo = dao.addTodo("spirng jdbc study!!");
//		System.out.println(todo);
	}

}
