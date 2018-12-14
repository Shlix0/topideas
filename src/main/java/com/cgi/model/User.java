package com.cgi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Login login;
	private Role role;
	private boolean activated;
	private List<Comment> comments = new ArrayList<Comment>();
	private List<Comment> commentsReported = new ArrayList<Comment>();
	private List<Idea> ideas = new ArrayList<Idea>();
	private List<Idea> ideasReported = new ArrayList<Idea>();
	private List<Idea> voteTop = new ArrayList<Idea>();
	private List<Idea> voteFlop = new ArrayList<Idea>();
	
	public User() {
	}

	
	
	public User(int id, String firstName, String lastName, Date birthDate, Login login, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.login = login;
		this.role = role;
		this.activated = false;
		this.comments = new ArrayList<Comment>();
		this.commentsReported = new ArrayList<Comment>();
		this.ideas = new ArrayList<Idea>();
		this.ideasReported = new ArrayList<Idea>();
		this.voteTop = new ArrayList<Idea>();
		this.voteFlop = new ArrayList<Idea>();
	}



	public User(int id, String firstName, String lastName, Date birthDate, Login login, Role role,
			List<Comment> comments, List<Comment> commentsReported, List<Idea> ideas, List<Idea> ideasReported,
			List<Idea> voteTop, List<Idea> voteFlop) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.login = login;
		this.role = role;
		this.activated = false;
		this.comments = comments;
		this.commentsReported = commentsReported;
		this.ideas = ideas;
		this.ideasReported = ideasReported;
		this.voteTop = voteTop;
		this.voteFlop = voteFlop;
	}


	public User(Role role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}

	public List<Comment> getCommentsReported() {
		return commentsReported;
	}

	public void setCommentsReported(List<Comment> commentsReported) {
		this.commentsReported = commentsReported;
	}

	public List<Idea> getIdeasReported() {
		return ideasReported;
	}

	public void setIdeasReported(List<Idea> ideasReported) {
		this.ideasReported = ideasReported;
	}

}
