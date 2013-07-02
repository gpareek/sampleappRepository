package net.gp.sample.user.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
    @Column(name="id")
    @GeneratedValue
	private String id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="salutation")
	private String salutation;
	
	@Column(name="password")
	private String password;
	
	@Column(name="receive_email")
	private boolean receiveMarketingEmail;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isReceiveMarketingEmail() {
		return receiveMarketingEmail;
	}

	public void setReceiveMarketingEmail(boolean receiveMarketingEmail) {
		this.receiveMarketingEmail = receiveMarketingEmail;
	}

}
