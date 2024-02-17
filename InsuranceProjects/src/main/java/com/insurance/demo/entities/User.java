package com.insurance.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="userData")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id ;
	@NotNull
	@Column(name="firstname")
	private String firstName;
	@NotNull
	@Column(name = "lastname")
	private String lastName;

	@Email(message = "Email is not valid !!")
	@Column(name = "useremail")
	private String userEmail;
	@Column(name = "username")
	
	@org.hibernate.validator.constraints.NotEmpty
	@Size(min = 4,message = "the UserName is not valid grow the size !")
	private String userName;
	@Column(name = "userage")
	@NotEmpty
//	@Size(max = 2,message = "the Age is not valid, the enter size two degit !")
	private Integer userAge;
	@Column(name = "gender")
	private Character gender;
	@Column(name = "userpassword")
	private String userPassword;
	@Column(name="city")
	private String city;

	@OneToMany(mappedBy = "userId")
	private List<Policy> policyList;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public List<Policy> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}

	public User(int id, String firstName, String lastName, String userEmail, String userName, Integer userAge,
			Character gender, String userPassword, String city) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userAge = userAge;
		this.gender = gender;
		this.userPassword = userPassword;
		this.city = city;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
