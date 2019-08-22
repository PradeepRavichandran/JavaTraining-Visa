package com.visa.prj.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="campaigns")
public class Campaign {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AUTO_INCREMENT
	private int cid;
	
	private String campaignName;
	private double target;
	private double amount;
	
	@JsonFormat(pattern="dd-MM-yyyy hh:mm")
	private Date deadline;
	
	private String status;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public double getTarget() {
		return target;
	}
	public void setTarget(double target) {
		this.target = target;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String c) {
		this.campaignName = c;
	}
	
	
}
