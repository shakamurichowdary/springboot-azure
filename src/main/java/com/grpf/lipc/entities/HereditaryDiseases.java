package com.grpf.lipc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hereditary_diseases")
public class HereditaryDiseases {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int herId;
	
	@Column(name = "heart_disease")
	private boolean heartDisease;
	
	@Column(name="high_blood_pressure")
	private boolean highBloodPressure;
	
	@Column
	private boolean alzheimer;
	
	@Column
	private boolean arthritis;
	
	@Column
	private boolean others;

	public int getHerId() {
		return herId;
	}

	public void setHerId(int herId) {
		this.herId = herId;
	}

	public boolean isHeartDisease() {
		return heartDisease;
	}

	public void setHeartDisease(boolean heartDisease) {
		this.heartDisease = heartDisease;
	}

	public boolean isHighBloodPressure() {
		return highBloodPressure;
	}

	public void setHighBloodPressure(boolean highBloodPressure) {
		this.highBloodPressure = highBloodPressure;
	}

	public boolean isAlzheimer() {
		return alzheimer;
	}

	public void setAlzheimer(boolean alzheimer) {
		this.alzheimer = alzheimer;
	}

	public boolean isArthritis() {
		return arthritis;
	}

	public void setArthritis(boolean arthritis) {
		this.arthritis = arthritis;
	}

	public boolean isOthers() {
		return others;
	}

	public void setOthers(boolean others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "HereditaryDiseases [herId=" + herId + ", heartDisease=" + heartDisease + ", highBloodPressure="
				+ highBloodPressure + ", alzheimer=" + alzheimer + ", arthritis=" + arthritis + ", others=" + others
				+ "]";
	}
	
	


}
