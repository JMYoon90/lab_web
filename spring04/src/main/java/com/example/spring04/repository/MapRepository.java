package com.example.spring04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring04.domain.Map;

public interface MapRepository extends JpaRepository<Map, Integer>{
	
	
}
