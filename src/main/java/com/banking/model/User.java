package com.banking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	
	@Id
	@SequenceGenerator (name="userGen", sequenceName = "userGen", initialValue = 10000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGen")
	private int userId;
	
	
	
	@NotEmpty
	@Size (max=40, message = "name should be less than 40 characters !")
	private String name;
	
	
	
	@NotEmpty
	@Email
	@Size (max = 100, message = "Email should be in proper format !")
	private String email;
	
	
	
	@NotEmpty
	@Size (min = 10, max = 10, message = "Mobile number should be 10 digits only")
	private String mobile;
	
	
	
	@Size (min=10, max=10, message = "Secondary mobile number should be 10 digits only")
	private String secondMobile;
	
	
	
	@NotEmpty
	@DateTimeFormat (pattern = "DD-MMM-YYYY")
	private String dob;
	
	
	
	@NotNull
	@Size (min=1,max=1, message = "Gender should be in single charater (Male=M, Female=F) and not empty !")
	private String gender;
	
	
	
	//one user has many accounts...one to many mapping 
	@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL)
	@JoinColumn(name="fk_uid", referencedColumnName = "userId")
	private List<Account> accounts;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	
	//trial 
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSecondMobile() {
		return secondMobile;
	}
	public void  setSecondMobile(String secondMobile) {
		this.secondMobile = secondMobile;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
}
