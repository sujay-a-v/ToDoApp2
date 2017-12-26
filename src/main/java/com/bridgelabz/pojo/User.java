package com.bridgelabz.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="User")
public class User { 
   

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	   private int id;
	   private String userName;
	   private String userEmail;
	   private String userMobile;
	   private String userPassword;
	   @Transient
	   private String confirmPassword;
	   
	   @OneToMany(mappedBy="user")
		@JsonIgnore
		private List<Notes> notes;
   
	   public User() {
		   
	   }
	   
	   
	   public User(int id, String userName, String userEmail, String userMobile) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
	}
	public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserMobile() {
			return userMobile;
		}
		public void setUserMobile(String userMobile) {
			this.userMobile = userMobile;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}


		@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobile="
					+ userMobile + ", userPassword=" + userPassword + ", confirmPassword=" + confirmPassword  + "]";
		}
		
		
		
		   
		
  
} 