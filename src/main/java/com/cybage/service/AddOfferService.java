package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.ApprovedGifts;
import com.cybage.model.Products;
import com.cybage.repository.ApprovedGiftsRepository;
import com.cybage.repository.ProductsRepository;

@Service
public class AddOfferService {

	@Autowired
	ApprovedGiftsRepository approvedRepo;
	@Autowired
	ProductsRepository productsRepo;
	
	public List<ApprovedGifts> getGiftList(){
		return approvedRepo.findAll();
	}
	
	public Products applyOffer(Products p)
	{
		return productsRepo.save(p);
	}
}
