package com.grpf.lipc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="occupation")
public class Occupation {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int occId;
	
	@Column
	private boolean business;
	
	@Column(name="public_sector")
	private boolean publicSector;
	
	@Column(name="private_sector")
	private boolean privateSector;
	
	@Column
	private boolean sports;
	
	@Column
	private boolean military;

	public int getOccId() {
		return occId;
	}

	public void setOccId(int occId) {
		this.occId = occId;
	}

	public boolean isBusiness() {
		return business;
	}

	public void setBusiness(boolean business) {
		this.business = business;
	}

	public boolean isPublicSector() {
		return publicSector;
	}

	public void setPublicSector(boolean publicSector) {
		this.publicSector = publicSector;
	}

	public boolean isPrivateSector() {
		return privateSector;
	}

	public void setPrivateSector(boolean privateSector) {
		this.privateSector = privateSector;
	}

	public boolean isSports() {
		return sports;
	}

	public void setSports(boolean sports) {
		this.sports = sports;
	}

	public boolean isMilitary() {
		return military;
	}

	public void setMilitary(boolean military) {
		this.military = military;
	}

	@Override
	public String toString() {
		return "Occupation [occId=" + occId + ", business=" + business + ", publicSector=" + publicSector
				+ ", privateSector=" + privateSector + ", sports=" + sports + ", military=" + military + "]";
	}

	
	

}
