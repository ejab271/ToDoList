package main.java.todoapp.dao;

import java.sql.SQLException;
import java.util.List;

import main.java.todoapp.model.Todo;

public interface TodoDao {

	void insertTodo(Todo todo) throws SQLException;

	Todo selectTodo(long todoId);

	List<Todo> selectAllTodos(String todoUserId);

	boolean deleteTodo(int id) throws SQLException;

	boolean updateTodo(Todo todo) throws SQLException;

}