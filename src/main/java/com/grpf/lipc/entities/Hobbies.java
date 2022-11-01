package com.grpf.lipc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="hobbies")
public class Hobbies {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hobId;
	
	@Column
	private boolean racing;
	
	@Column(name="sky_diving")
	private boolean skyDiving;
	
	@Column(name="bungee_jumping")
	private boolean bungeeJumping;
	
	@Column(name="scuba_diving")
	private boolean scubaDiving;
	
	@Column
	private boolean others;

	public int getHobId() {
		return hobId;
	}

	public void setHobId(int hobId) {
		this.hobId = hobId;
	}

	public boolean isRacing() {
		return racing;
	}

	public void setRacing(boolean racing) {
		this.racing = racing;
	}

	public boolean isSkyDiving() {
		return skyDiving;
	}

	public void setSkyDiving(boolean skyDiving) {
		this.skyDiving = skyDiving;
	}

	public boolean isBungeeJumping() {
		return bungeeJumping;
	}

	public void setBungeeJumping(boolean bungeeJumping) {
		this.bungeeJumping = bungeeJumping;
	}

	public boolean isScubaDiving() {
		return scubaDiving;
	}

	public void setScubaDiving(boolean scubaDiving) {
		this.scubaDiving = scubaDiving;
	}

	public boolean isOthers() {
		return others;
	}

	public void setOthers(boolean others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "Hobbies [hobId=" + hobId + ", racing=" + racing + ", skyDiving=" + skyDiving + ", bungeeJumping="
				+ bungeeJumping + ", scubaDiving=" + scubaDiving + ", others=" + others + "]";
	}
	
	
	

}
