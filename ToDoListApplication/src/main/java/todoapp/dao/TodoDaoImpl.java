package main.java.todoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.todoapp.model.Todo;
import main.java.todoapp.model.User;
import main.java.todoapp.utils.JDBCUtils;

/**
 * This DAO class provides CRUD database operations for the table todos in the
 * database.
 *
 */

public class TodoDaoImpl implements TodoDao {

	private static final String INSERT_TODOS_SQL = "INSERT INTO todolist"
			+ "  (title, ts, user_id, description, target_date,  is_done) VALUES " + " (?, NOW(), ?, ?, ?, ?);";

	private static final String SELECT_TODO_BY_ID = "select todolist.id,todolist.ts,todolist.title,todolist.user_id,todolist.description,todolist.target_date,todolist.is_done from todolist  INNER JOIN users ON users.username = todolist.user_id where todolist.id =?";
	private static final String SELECT_ALL_TODOS = "select todolist.id,todolist.ts,todolist.title,todolist.user_id,todolist.description,todolist.target_date,todolist.is_done from todolist  INNER JOIN users ON todolist.user_id = users.username where todolist.user_id = ?";
	private static final String DELETE_TODO_BY_ID = "delete from todolist where id = ?;";
	private static final String UPDATE_TODO = "UPDATE todolist set title = ?, ts = NOW(),  description =?, target_date =?, is_done = ? where id = ?;";


	public TodoDaoImpl() {
	}

	@Override
	public void insertTodo(Todo todo) throws SQLException {
		System.out.println(INSERT_TODOS_SQL);
		
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TODOS_SQL);) {
			
			
			preparedStatement.setString(1, todo.getTitle());
			//preparedStatement.setString(2, todo.getTeam());
			preparedStatement.setString(2, todo.getUserId());
			preparedStatement.setString(3, todo.getDescription());
			preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
			preparedStatement.setBoolean(5, todo.getStatus());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			}
		
	}
	

	@Override
	public Todo selectTodo(long todoId) {
		Todo todo = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TODO_BY_ID);) {
			preparedStatement.setLong(1, todoId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				LocalDate ts = rs.getDate("ts").toLocalDate();
				String title = rs.getString("title");
				//String team = rs.getString("team");
				String userId = rs.getString("user_id");
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("is_done");
				todo = new Todo(id, ts, userId, title, description, targetDate, isDone); 
				
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return todo;
	}

	@Override
	public List<Todo> selectAllTodos(String toDoUserId) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Todo> todos = new ArrayList<>();
	// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TODOS);) {
			preparedStatement.setString(1, toDoUserId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				LocalDate ts= rs.getDate("ts").toLocalDate();
				String title = rs.getString("title");
				//String team = rs.getString("team");
				 String userId = rs.getString("user_id");
				//System.out.println("USERID!" +userID);
				String description = rs.getString("description");
				LocalDate targetDate = rs.getDate("target_date").toLocalDate();
				boolean isDone = rs.getBoolean("is_done");
				todos.add(new Todo(id, ts,userId, title, description, targetDate, isDone));
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return todos;
	}

	@Override
	public boolean deleteTodo(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TODO_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	@Override
	public boolean updateTodo(Todo todo) throws SQLException {
		boolean rowUpdated;
		
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TODO);) {
			statement.setString(1, todo.getTitle());
			//statement.setString(2, todo.getTeam());
			statement.setString(2, todo.getDescription());
			statement.setDate(3, JDBCUtils.getSQLDate(todo.getTargetDate()));
			statement.setBoolean(4, todo.getStatus());
			//statement.setLong(5, todo.getUserId());
			statement.setLong(5, todo.getId());
	
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
