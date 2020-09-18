package main.java.todoapp.model;

import java.time.LocalDate;


/**
 * Todo.java
 * This is a model class represents a Todo entity
 *
 */
public class Todo {

	private Long id;
	private LocalDate ts;
	private String userId;
	private String title;
	//private String team;
	private String description;
	private LocalDate targetDate;
	private boolean status;

	
	public Todo(long id, LocalDate ts,String userId, String title,  String description, LocalDate targetDate, boolean isDone) {
		super();
		this.id = id;
		this.ts = ts;
		this.userId = userId;
		this.title = title;
		//this.team = team;
		this.description = description;
		this.targetDate = targetDate;
		this.status = isDone;
	}

	public Todo(String title, String userId, String description, LocalDate targetDate, boolean isDone) {
		super();
		this.title = title;
		//this.team = team;
		this.userId = userId;
		this.description = description;
		this.targetDate = targetDate;
		this.status = isDone;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getTs() {
		return ts;
	}

	public void setTs(LocalDate ts) {
		this.ts = ts;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
//	public String getTeam() {
//		return team;
//	}
//
//	public void setTeam(String team) {
//		this.team = team;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
