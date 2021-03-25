package com.cybage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.model.Supplier;
import com.cybage.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository supplierRepository;
	
	public Supplier addSupplier(Supplier s){
		return supplierRepository.save(s);
	}
	

	public List<Supplier> deleteSupplier(long gid){
		Supplier s=supplierRepository.getOne(gid);
		supplierRepository.delete(s);
		 return getSupplierList();
		}
	


	public List<Supplier> getSupplierList(){
	return supplierRepository.findAll();
	}
	
	public Supplier searchSupplier(long gid){
		Supplier s = supplierRepository.getOne(gid);
				return s;
	}




}
