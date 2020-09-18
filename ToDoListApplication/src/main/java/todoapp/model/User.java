package main.java.todoapp.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * JavaBean class used in jsp action tags.
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getTeam() {
//		return team;
//	}
//	public void setTeam(String team) {
//		this.team = team;
//	}

}
