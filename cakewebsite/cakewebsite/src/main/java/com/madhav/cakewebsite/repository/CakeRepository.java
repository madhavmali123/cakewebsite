package com.madhav.cakewebsite.repository;

import com.madhav.cakewebsite.model.Cake;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {

	List<Cake> findAll();
	
}
