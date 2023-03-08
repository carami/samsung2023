package com.exam.todomvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todomvc.domain.Todo;

@Repository
public class TodoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		String sql = "select id,todo,done from todos order by id desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Todo.class));
	}
	@Transactional
	public int insertTodo(String todo) {
		String sql = "insert into todos(todo,done) values (?,false)";
		return jdbcTemplate.update(sql,todo);
	}

}
