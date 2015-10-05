package org.activityplanner.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AP_USER", uniqueConstraints=@UniqueConstraint(columnNames={"USER_NAME", "MAIL_ID"}))
public class UserEntity {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private Integer userId;
	@Column(name = "MAIL_ID")
	private String mailId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "FULLNAME")
	private String fullName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}