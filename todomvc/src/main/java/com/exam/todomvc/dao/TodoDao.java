package com.exam.todomvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todomvc.domain.Todo;

@Repository
public class TodoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	@PostConstruct
	public void init() {
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("todos").usingGeneratedKeyColumns("id");
	}
	
	@Transactional
	public Todo addTodo(String todo) {
		Map<String, Object> parms = new HashMap();
		parms.put("todo", todo);
		parms.put("done", false);
		
		Number pk =	simpleJdbcInsert.executeAndReturnKey(parms);
		
		Todo newTodo = new Todo();
		newTodo.setId(pk.longValue());
		newTodo.setTodo(todo);
		newTodo.setDone(false);
		
		return newTodo;
	}
	
	
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
	
	@Transactional
	public void deleteTodo(Long id) {
		String sql = "delete from todos where id = ?";
		jdbcTemplate.update(sql,id);
	}
	
	@Transactional
	public void updateTodo(Todo todo) {
		String sql = "update todos set done = ? where id = ?";
		jdbcTemplate.update(sql,todo.isDone(), todo.getId());
	}
	
	public Todo getTodo(Long id) {
		String sql = "select id, todo,done from todos where id = ?";
		return jdbcTemplate.queryForObject(sql, new TodoMapper(),id);
	}
	
	public static class TodoMapper implements RowMapper<Todo>{

		@Override
		public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Todo todo = new Todo();
			todo.setId(rs.getLong("id"));
			todo.setTodo(rs.getString("todo"));
			todo.setDone(rs.getBoolean("done"));
			return todo;
		}
		
	}
}
