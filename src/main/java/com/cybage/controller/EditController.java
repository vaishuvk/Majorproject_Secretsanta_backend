package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Products;
import com.cybage.service.EditService;


@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
@RequestMapping("/apiE")
public class EditController {

	@Autowired
	EditService productService;
	
	@GetMapping("/productList")
	public List<Products> productList()
	{
		return productService.getProductList();
	}

	@PostMapping("/editproduct/{id}")
	public Products productList(@PathVariable Long id,@RequestBody Products p){
		System.out.println("Edit");
		Products p1 = productService.searchProducts(id);
		productService.editProducts(p, p1);
		return p1;
		}
	
	@PutMapping("/delete/{id}")
	public void deleteProduct(@PathVariable Long id){
		System.out.println("In Delete");
		productService.softdelete(id);
	
	}
}
