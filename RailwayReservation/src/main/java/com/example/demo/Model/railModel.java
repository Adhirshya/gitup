package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Railway")
public class railModel 
{
	@Id
	private int trainid;
	private String tname;
	private String source;
	private String destination;
	private String depTime;
	private String lanTime;
    private int reservId;
    private int passid;
    private String passName;
    private int passAge;
	public int getTrainid() {
		return trainid;
	}
	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getLanTime() {
		return lanTime;
	}
	public void setLanTime(String lanTime) {
		this.lanTime = lanTime;
	}
	public int getReservId() {
		return reservId;
	}
	public void setReservId(int reservId) {
		this.reservId = reservId;
	}
	public int getPassid() {
		return passid;
	}
	public void setPassid(int passid) {
		this.passid = passid;
	}
	public String getPassName() {
		return passName;
	}
	public void setPassName(String passName) {
		this.passName = passName;
	}
	public int getPassAge() {
		return passAge;
	}
	public void setPassAge(int passAge) {
		this.passAge = passAge;
	}
	
	
}
