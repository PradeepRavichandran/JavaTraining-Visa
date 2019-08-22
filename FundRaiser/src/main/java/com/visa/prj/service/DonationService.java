package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CampaignDao;
import com.visa.prj.dao.DonationDao;
import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;
import com.visa.prj.entity.DonationReport;

@Service
public class DonationService {

	@Autowired
	private DonationDao donationDao;
	
	@Autowired
	private CampaignDao campaignDao;
	
	public List<Campaign> getCampaigns(){
		return campaignDao.findAll();
	}
	
	public List<DonationReport> getDonations(){
		return donationDao.findDonations();
	}
	
	@Transactional 
	public int saveCampaign(Campaign c) {
		//springboot gives this save()
		campaignDao.save(c);
		return c.getCid();
	}
	
	@Transactional
	public int saveDonation(Donation d) {
		donationDao.save(d);
		Campaign c = d.getCampaign();
		double amt = c.getAmount();
		c.setAmount(amt + d.getAmount());
		
		return d.getDonationId();
	}
	
}
