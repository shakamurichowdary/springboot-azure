package com.grpf.lipc.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;







@Entity
@Table(name="submission")
public class Submission  {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subId;
	
	@Column
	private boolean smoking;
	
	@Column
	private boolean drinking;


	
	@Column
	private int coverage;
	
	@Column
	private int years;
	

	@Column
	private LocalDate DOB;
	

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "hobbies_id", nullable=false)
	private Hobbies hobbies;
	
	 	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "medical_id", nullable=false)
	private Medical medical;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "occupation_id", nullable=false)
	private Occupation occupation;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "hereditarydiseases_id", nullable=false)
	private HereditaryDiseases hereditaryDiseases;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "quote_id")
	private Quote quote;
	
	

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}
	

	

	public HereditaryDiseases getHereditaryDiseases() {
		return hereditaryDiseases;
	}

	public void setHereditaryDiseases(HereditaryDiseases hereditaryDiseases) {
		this.hereditaryDiseases = hereditaryDiseases;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public int getCoverage() {
		return coverage;
	}

	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userId", nullable=false)
//	@JsonIgnore
	private User user;
	
	@OneToOne(mappedBy="submission",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private Beneficiary beneficiary;
	
	
	
	
	
	public Hobbies getHobbies() {
		return hobbies;
	}

	public void setHobbies(Hobbies hobbies) {
		this.hobbies = hobbies;
	}

	public Medical getMedical() {
		return medical;
	}

	public void setMedical(Medical medical) {
		this.medical = medical;
	}

	public Occupation getOccupation() {
		return occupation;
	}

	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public boolean isDrinking() {
		return drinking;
	}

	public void setDrinking(boolean drinking) {
		this.drinking = drinking;
	}

	

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Submission [subId=" + subId + ", smoking=" + smoking + ", drinking=" + drinking + ", coverage="
				+ coverage + ", years=" + years + ", DOB=" + DOB + ", hobbies=" + hobbies + ", medical=" + medical
				+ ", occupation=" + occupation + ", hereditaryDiseases=" + hereditaryDiseases + ", user=" + user
				+ ", beneficiary=" + beneficiary + "]";
	}


	
	
	
	
	
	
	

}
