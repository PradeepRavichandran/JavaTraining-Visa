package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visa.prj.entity.Donation;
import com.visa.prj.entity.DonationReport;

public interface DonationDao extends JpaRepository<Donation, Integer> {

	// new <full classname>(params) - for reporting as new entity
	@Query("select new com.visa.prj.entity.DonationReport(d.campaign.campaignName, d.donor, d.donationDate, d.amount, d.status) from Donation d")
	public List<DonationReport> findDonations();
}
