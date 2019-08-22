package com.visa.prj.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DonationReport {
	private String campaignName;
	private String donor;
	
	@JsonFormat(pattern="dd-MM-yyyy hh:mm")
	private Date donation_date;
	
	private double amt;
	private String status;
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getDonor() {
		return donor;
	}
	public void setDonor(String donor) {
		this.donor = donor;
	}
	public Date getDonation_date() {
		return donation_date;
	}
	public void setDonation_date(Date donation_date) {
		this.donation_date = donation_date;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DonationReport(String campaignName, String donor, Date donation_date, double amt, String status) {
		super();
		this.campaignName = campaignName;
		this.donor = donor;
		this.donation_date = donation_date;
		this.amt = amt;
		this.status = status;
	}
	
	

}
