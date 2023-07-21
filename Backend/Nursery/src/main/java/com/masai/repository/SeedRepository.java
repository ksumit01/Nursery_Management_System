package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Seed;

public interface SeedRepository extends JpaRepository<Seed,Integer>,PagingAndSortingRepository<Seed,Integer>{
Optional<Seed> findByCommonName(String commonName);
}
