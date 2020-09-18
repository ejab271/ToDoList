package main.java.todoapp.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.todoapp.dao.LoginDao;
import main.java.todoapp.model.LoginBean;
import main.java.todoapp.model.User;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		authenticate(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			User user = loginDao.validate(username, password);
				request.setAttribute("user", user);
				String destpage = null;
				if (user != null) {
		            HttpSession session = request.getSession();
		            session.setAttribute("user", user);
		             destpage = ("todo/todo-list.jsp");
		            
		        } else {
		        	request.setAttribute("NOTIFICATION", "You entered incorrect Username or Password.");
					destpage = ("login/login.jsp");
					
		        }
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(destpage);
		        dispatcher.forward(request, response);
		         
		    } catch (SQLException | ClassNotFoundException ex) {
		        throw new ServletException(ex);
		    

	}
  }
}
