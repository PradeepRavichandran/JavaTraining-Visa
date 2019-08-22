package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;
import com.visa.prj.entity.DonationReport;
import com.visa.prj.service.DonationService;

@RestController
public class CampaignController {

	@Autowired
	private DonationService ds;
	
	@GetMapping("campaigns")
	public @ResponseBody List<Campaign> fetchCampaigns(){
		return ds.getCampaigns();
	}
	
	@PostMapping("campaigns")
	public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign c){
		ds.saveCampaign(c);
		return new ResponseEntity<>(c, HttpStatus.CREATED);  //201
	}
	
	
	
}
