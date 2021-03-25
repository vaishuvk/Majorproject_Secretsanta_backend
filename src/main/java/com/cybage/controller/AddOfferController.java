package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.ApprovedGifts;
import com.cybage.model.Products;
import com.cybage.service.AddOfferService;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
public class AddOfferController {
	
	@Autowired
	AddOfferService addservice;
	
	@GetMapping("/approvedlist")
	public List<ApprovedGifts> approvedGifts(){
		return addservice.getGiftList();
	}
	
	@PostMapping("/addoffer")
	public Products addoffer(Products p)
	{
		return addservice.applyOffer(p);
	}
}
