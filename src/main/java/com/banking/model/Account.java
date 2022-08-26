package com.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {
	
	@Id
	@SequenceGenerator (name="accountGen", sequenceName = "accountGen", initialValue = 1000000000)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "accountGen")
	private long accountId; //id is not generated properly
	
	@Size (max = 40, message = "Character size should be less than 40 ! Please enter valid inputs..")
	@NotEmpty
	private String branchName;
	
	@Size(max= 1, message = "Account type must be in single character (Saving=S, Current=C) and not empty !")
	@NotEmpty
	private String accountType;
	
	
	@PositiveOrZero (message = "Balance cant be negative ! please enter positive ammount !")
	private double balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
