package main.java.todoapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import main.java.todoapp.model.LoginBean;
import main.java.todoapp.model.User;
import main.java.todoapp.utils.JDBCUtils;

public class LoginDao {
	public User validate(String username, String password) throws ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from users where username = ? and password = ? ");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
		

			User user = null;
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getLong("id"));
				user.setUsername(username);
				
	}
			
			connection.close();
			
			return user;
	
}
}
