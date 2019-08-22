package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visa.prj.entity.Campaign;

public interface CampaignDao extends JpaRepository<Campaign, Integer> {

	
}
