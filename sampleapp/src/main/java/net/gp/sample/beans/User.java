package net.gp.sample.beans;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import net.gp.sample.validation.constraints.Extended;
import net.gp.sample.validation.constraints.PasswordReTypePasswordMatchConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@PasswordReTypePasswordMatchConstraint(message = "passwords are not equal.", groups = Extended.class)
public class User {
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	@Email
	private String email;
		
	@DateTimeFormat(iso=ISO.DATE)
	@Past
	private Date dateOfBirth;
	
	@NotEmpty
	private String salutation;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String reTypePassword;
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
	public String getReTypePassword() {
		return reTypePassword;
	}
	public void setReTypePassword(String reTypePassword) {
		this.reTypePassword = reTypePassword;
	}
	public boolean isReceiveMarketingEmail() {
		return receiveMarketingEmail;
	}
	public void setReceiveMarketingEmail(boolean receiveMarketingEmail) {
		this.receiveMarketingEmail = receiveMarketingEmail;
	}
}
