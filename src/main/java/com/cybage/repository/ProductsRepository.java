package com.cybage.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	
	
	 @Modifying
	 @Transactional
	 @Query(value ="UPDATE Products p SET p.visibility = 0 WHERE p.pid = :id", nativeQuery=true)
	  public void deleteProduct(@Param("id") Long pid);
	 
	
	 @Query(value="Select * from Products p where p.visibility = 1",nativeQuery=true)
	 public List<Products> listProducts();
}


