package com.grpf.lipc.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "user_entity")
public class User {
	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private Set<Submission> questions = new HashSet<>();
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "perId", nullable=false)
	private Person person;
	

	
	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public User(@NotNull int userId, String email, String password,
			Set<Submission> questions) {
		super();
		this.userId = userId;
		
		this.email = email;
		this.password = password;
		this.questions = questions;
	}

	@JsonIgnore
	public Set<Submission> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Submission> questions) {
		this.questions = questions;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

	

	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	

	public User() {
		super();
	}



	
	
	
	
	
	

}
