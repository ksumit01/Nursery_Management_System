package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Plant;

public interface Plantrepository extends JpaRepository<Plant,Integer>,PagingAndSortingRepository<Plant,Integer>{

	public Optional<Plant> findByCommonName(String commonname);
	
	public Optional<Plant> findByTypeOfPlant(String typofplant);
}
