package com.grpf.lipc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="medical")
public class Medical {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medId;
	
	@Column
	private boolean diabaties;
	
	@Column(name="blood_pressure")
	private boolean bloodPressure;
	
	@Column(name="cancer")
	private boolean cancer;
	
	@Column(name="brain_tumor")
	private boolean brainTumor;
	
	@Column
	private boolean others;

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public boolean isDiabaties() {
		return diabaties;
	}

	public void setDiabaties(boolean diabaties) {
		this.diabaties = diabaties;
	}

	public boolean isBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(boolean bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public boolean isCancer() {
		return cancer;
	}

	public void setCancer(boolean cancer) {
		this.cancer = cancer;
	}

	public boolean isBrainTumor() {
		return brainTumor;
	}

	public void setBrainTumor(boolean brainTumor) {
		this.brainTumor = brainTumor;
	}

	public boolean isOthers() {
		return others;
	}

	public void setOthers(boolean others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "Medical [medId=" + medId + ", diabaties=" + diabaties + ", bloodPressure=" + bloodPressure + ", cancer="
				+ cancer + ", brainTumor=" + brainTumor + ", others=" + others + "]";
	}
	
	
	


}
