package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Products;
import com.cybage.repository.ProductsRepository;

@Service
public class EditService {

	@Autowired
	ProductsRepository productRepo;
	
	public Products editProducts(Products p,Products p1){
		System.out.println("editproducts");
		p1.setGiftname(p.getGiftname());
		p1.setPrice(p.getPrice());
		p1.setQuantity(p.getQuantity());
		/*p1.setDiscountoffer(p1.getDiscountoffer());*/
		return productRepo.save(p1);
	}
	
	public Products searchProducts(Long id){
		System.out.println("search");
		Products p = productRepo.findById(id).get();
		return p;
	}
	
	public List<Products> getProductList(){
		return productRepo.listProducts();
	}
	
	public void softdelete(Long id)
	{
		System.out.println("in delete service");
		 productRepo.deleteProduct(id);
	}
}
