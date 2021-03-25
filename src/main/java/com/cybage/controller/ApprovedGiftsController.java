package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.model.ApprovedGifts;
import com.cybage.service.ApprovedGiftsService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api")
public class ApprovedGiftsController {

	@Autowired
	ApprovedGiftsService approvedGiftsService;
	
		@PostMapping("/addApproved")
		public ApprovedGifts ApprovedGiftsList(@RequestBody ApprovedGifts a){
			return approvedGiftsService.addApprovedGifts(a);
			}
}
