package test.java.todoapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.mysql.cj.Session;


import main.java.todoapp.dao.LoginDao;
import main.java.todoapp.utils.JDBCUtils;

public class TestLoginDao {
	  
	    private Session session;
	   
	    
	    private LoginDao loginDAO;
	    
	    
		
		Connection connection = JDBCUtils.getConnection();
		
		
//	    @BeforeEach
//	    public void prepare() throws Exception {
//	        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
//	        loginDAO = new LoginDao(sessionFactory);
//	    }
//
//	void addsTwoNumbers() {
//		  
//		        assertEquals(true,true);
//		    
//	}

}


