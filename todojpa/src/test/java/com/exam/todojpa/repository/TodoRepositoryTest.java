package com.exam.todojpa.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = ApplicationConfig.class)
@Transactional
public class TodoRepositoryTest {
	@Autowired
	private TodoRepository todoRepository;
	
	private static Logger logger = LoggerFactory.getLogger(TodoRepository.class);
	
	@Test
	void test() {
		logger.info("test 메소드 실행!!");
	}
	
	@Test
	void test2() {
		logger.info("test22 메소드 실행!!");
	}
	
	@BeforeAll
	static void setUp() {
		logger.info("------------------>@BeforeAll 메소드 실행!!!");
	}
	
	@AfterAll
	static void tearDown() {
		logger.info("------------------>@AfterAll 메소드 실행!!!");
	}
	
	@BeforeEach
	void init() {
		logger.info("------------------>@BeforeEach 메소드 실행!!!");
	}
	@AfterEach
	void dispose() {
		logger.info("------------------>@AfterEach 메소드 실행!!!");
	}
	
	@Test
	void save() {
		logger.info("save~~~");
		Todo todo = new Todo();
		todo.setTodo("junit  tlftmq");
		
		todo = todoRepository.save(todo);
		
		assertNotNull(todo);
		assertNotNull(todo.getId());
	}
	
}
