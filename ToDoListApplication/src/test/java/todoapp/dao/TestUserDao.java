package test.java.todoapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.mysql.cj.Session;

import main.java.todoapp.dao.LoginDao;
import main.java.todoapp.dao.UserDao;
import main.java.todoapp.model.User;

public class TestUserDao {
		private Session session;
	   	    
	    private UserDao userDao;
	    
	   @Test
	    public void testAddUser() throws ClassNotFoundException
	    {
		         
			User user = new User();
	       
	        user.setFirstName("Bobby");
	        user.setLastName("Joe");
	        user.setUsername("BobbyJoe");
	        user.setPassword("BobbyJoe123");
	         
	        userDao.registerEmployee(user);
	        Assert.assertNotNull(userDao);
	        Assert.assertEquals( "Bobby", user.getFirstName());
	         
	    }
//	}

}


