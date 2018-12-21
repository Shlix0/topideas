package com.cgi.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Idea {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String picture;
	private String content;
	private Date creationDate = new Date();
	private LocalDate finishVotableDate = LocalDate.now().plusDays(7);
	private Boolean votable = true;
	private Boolean enable = true;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
	
	@ManyToMany(mappedBy="ideasReported")
	private Collection<User> usersReport = new HashSet<User>();
	
	@ManyToMany(mappedBy="voteTop")
	private Collection<User> usersVoteTop = new HashSet<User>();
	
	@ManyToMany(mappedBy="voteFlop")
	private Collection<User> usersVoteFlop = new HashSet<User>();
	
	@OneToMany(mappedBy="idea")
	private Collection<Comment> comments = new HashSet<Comment>(); ;

	public Idea() {
	}

	public Idea(String title, String picture, String content, Date creationDate, LocalDate finishVotableDate,
			Boolean votable, Boolean enable, Category category, User user) {
		super();
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.creationDate = creationDate;
		this.finishVotableDate = finishVotableDate;
		this.votable = votable;
		this.enable = enable;
		this.category = category;
		this.user = user;
		this.usersReport = new HashSet<User>();
		this.usersVoteTop = new HashSet<User>();
		this.usersVoteFlop = new HashSet<User>();
		this.comments = new HashSet<Comment>();;
	}

	public Idea(Long id, String title, String picture, String content, Date creationDate, LocalDate finishVotableDate,
			Boolean votable, Boolean enable, Category category, User user, Collection<User> usersReport,
			Collection<User> usersVoteTop, Collection<User> usersVoteFlop, Collection<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.content = content;
		this.creationDate = creationDate;
		this.finishVotableDate = finishVotableDate;
		this.votable = votable;
		this.enable = enable;
		this.category = category;
		this.user = user;
		this.usersReport = usersReport;
		this.usersVoteTop = usersVoteTop;
		this.usersVoteFlop = usersVoteFlop;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDate getFinishVotableDate() {
		return finishVotableDate;
	}

	public void setFinishVotableDate(LocalDate finishVotableDate) {
		this.finishVotableDate = finishVotableDate;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<User> getUsersReport() {
		return usersReport;
	}

	public void setUsersReport(Collection<User> usersReport) {
		this.usersReport = usersReport;
	}

	public Collection<User> getUsersVoteTop() {
		return usersVoteTop;
	}

	public void setUsersVoteTop(Collection<User> usersVoteTop) {
		this.usersVoteTop = usersVoteTop;
	}

	public Collection<User> getUsersVoteFlop() {
		return usersVoteFlop;
	}

	public void setUsersVoteFlop(Collection<User> usersVoteFlop) {
		this.usersVoteFlop = usersVoteFlop;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", title=" + title + ", picture=" + picture + ", content=" + content
				+ ", creationDate=" + creationDate + ", finishVotableDate=" + finishVotableDate + ", votable=" + votable
				+ ", enable=" + enable + ", category=" + category + ", user=" + user + ", usersReport=" + usersReport
				+ ", usersVoteTop=" + usersVoteTop + ", usersVoteFlop=" + usersVoteFlop + ", comments=" + comments
				+ "]";
	}
	
}