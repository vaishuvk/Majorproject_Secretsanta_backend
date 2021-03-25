package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.model.Supplier;
import com.cybage.service.SupplierService;
@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api")
public class SupplierController {


    @Autowired
	SupplierService supplierService;
    
    @GetMapping("/getList")
	public List<Supplier> getlist()
	{
		return supplierService.getSupplierList();
		
	}

}
