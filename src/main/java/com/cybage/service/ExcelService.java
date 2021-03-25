package com.cybage.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.cybage.model.Supplier;
import com.cybage.repository.SupplierRepository;


@Service
public class ExcelService {

	@Autowired
	private SupplierRepository supplierRepository;

	public String addSupplierFileData(Supplier s) {
		System.out.println("In Excel Service");
		supplierRepository.save(s);
		return "successfully added";
		
	}
} 