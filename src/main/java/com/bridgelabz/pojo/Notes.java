package com.bridgelabz.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ToDoNotes")
public class Notes {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date createDate;
	private Date modifiedDate;
	private String title;
	private String description;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="userId")
	private User user;
	
	
	private String reminder;
	private String archive;
	private String trash;
	private String pin;
	private String color;

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		/*if(reminder.equals("true")||reminder.equals("false"))*/
		this.reminder = reminder;
	}

	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		if(archive.equals("true")|| archive.equals("false"))
		this.archive = archive;
	}

	public String getTrash() {
		return trash;
	}

	public void setTrash(String trash) {
		if(trash.equals("true")|| trash.equals("false"))
		this.trash = trash;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		if(pin.equals("true") || pin.equals("false"))
			this.pin = pin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", title=" + title
				+ ", description=" + description + "]";
	}
	
	
}
