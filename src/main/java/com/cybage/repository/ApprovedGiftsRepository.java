package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.ApprovedGifts;

@Repository
public interface ApprovedGiftsRepository extends JpaRepository<ApprovedGifts, Long> {

}
