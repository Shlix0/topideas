package com.cgi.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {

	private int id;
	private String title;
	private String content;
	private Idea idea;
	private List<User> usersReports = new ArrayList<User>();

	public Comment() {
	}

	public Comment(int id, String title, String content, Idea idea) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.idea = idea;
		this.usersReports = new ArrayList<User>();
	}

	public Comment(int id, String title, String content, Idea idea, List<User> usersReports) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.idea = idea;
		this.usersReports = usersReports;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<User> getUsersReports() {
		return usersReports;
	}

	public void setUsersReports(List<User> usersReports) {
		this.usersReports = usersReports;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}

}
