package com.grpf.lipc.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "beneficiaryDetails_entity")
public class Beneficiary {
	
	
	
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int beneficiaryId;  
	
	
	@Column(name = "beneficiary_gender")
	private String beneficiaryGender;
	
	@Column(name = "beneficiary_age")
	private int beneficiaryAge;
	
	@Column(name = "beneficiary_relation")
	private String beneficiaryRelation;
		
	@Column(name = "beneficiary_email")
	private String beneficiaryEmail;
	
	@Column(name = "tax_id")
	private String taxId;
	

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "subId", nullable=false)
	private Submission submission;   
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "perId", nullable=false)
	private Person person;
	
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getBeneficiaryGender() {
		return beneficiaryGender;
	}

	public void setBeneficiaryGender(String beneficiaryGender) {
		this.beneficiaryGender = beneficiaryGender;
	}

	public int getBeneficiaryAge() {
		return beneficiaryAge;
	}

	public void setBeneficiaryAge(int beneficiaryAge) {
		this.beneficiaryAge = beneficiaryAge;
	}

	public String getBeneficiaryEmail() {
		return beneficiaryEmail;
	}

	public void setBeneficiaryEmail(String beneficiaryEmail) {
		this.beneficiaryEmail = beneficiaryEmail;
	}

	
	
	
	public int getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}


	
	
	public Beneficiary() {
		
	}
	
	
	


	
	public String getBeneficiaryRelation() {
		return beneficiaryRelation;
	}

	public void setBeneficiaryRelation(String beneficiaryRelation) {
		this.beneficiaryRelation = beneficiaryRelation;
	}

	
	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(Submission submission) {
		this.submission = submission;
	}

	
	

	


	

	

}
