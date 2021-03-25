package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.model.ApprovedGifts;
import com.cybage.repository.ApprovedGiftsRepository;

@Service
public class ApprovedGiftsService {
	
	@Autowired
	ApprovedGiftsRepository approvedGiftsRepository;
	

	public ApprovedGifts addApprovedGifts(ApprovedGifts a){
		return approvedGiftsRepository.save(a);
	}
}
