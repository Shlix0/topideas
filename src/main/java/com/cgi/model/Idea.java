package com.cgi.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Idea {

	private int id;
	private String title;
	private String picture;
	private String content;
	private Date creationDate = new Date();
	private LocalDate finishVotableDate = LocalDate.now().plusDays(7);
	private Boolean votable = true;
	private Boolean enable = true;
	private User user;
	private Category category;
	private List<User> usersVoteTop = new ArrayList<User>();
	private List<User> usersVoteFlop = new ArrayList<User>();
	private List<Comment> comments = new ArrayList<Comment>();

	public Idea() {
	}

	public Idea(int id, String title, String picture, String content, Date creationDate, User user, Category category) {
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.creationDate = creationDate;
		this.user = user;
		this.category = category;
		this.usersVoteTop = new ArrayList<User>();
		this.usersVoteFlop = new ArrayList<User>();
		this.comments = new ArrayList<Comment>();
		this.votable = checkVotable();
	}


	public Idea(int id, String title, String picture, String content, Date creationDate, LocalDate finishVotableDate,
			Boolean votable, Boolean enable, User user, Category category, List<User> usersVoteTop,
			List<User> usersVoteFlop, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.creationDate = creationDate;
		this.finishVotableDate = finishVotableDate;
		this.votable = checkVotable();
		this.enable = enable;
		this.user = user;
		this.category = category;
		this.usersVoteTop = usersVoteTop;
		this.usersVoteFlop = usersVoteFlop;
		this.comments = comments;
	}

	
	// -------------------------------------- ATTENTION BESOIN DE VERIFER CETTE CHOSE -------------------------------------- // 
	public boolean checkVotable() {
		Date finish = Date.from(this.finishVotableDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date now = new Date();
		if( now.compareTo(finish) > 0)  {
			return false;
		}
		else {
			return true;
		}
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getVotable() {
		return votable;
	}

	public void setVotable(Boolean votable) {
		this.votable = votable;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<User> getUsersVoteTop() {
		return usersVoteTop;
	}

	public void setUsersVoteTop(List<User> usersVoteTop) {
		this.usersVoteTop = usersVoteTop;
	}

	public List<User> getUsersVoteFlop() {
		return usersVoteFlop;
	}

	public void setUsersVoteFlop(List<User> usersVoteFlop) {
		this.usersVoteFlop = usersVoteFlop;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
