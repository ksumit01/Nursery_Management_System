package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.PlantException;
import com.masai.exception.SeedException;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.repository.SeedRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SeedServiceImpl implements SeedService{

	@Autowired
	private SeedRepository sRepo;
	
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		if(seed == null) throw new SeedException("seed is null") ; 
		Optional<Seed> cus = sRepo.findById(seed.getSeedId()) ;
    	if(cus.isPresent()) throw new SeedException("Seed already present in database") ;
    		sRepo.save(seed) ;
    		log.info("seed added successfully");
		return seed;
	}

	@Override
	public Seed updateSeed(Integer seedId, Seed updatedSeed) throws SeedException {
		Seed existSeed = sRepo.findById(seedId)
        .orElseThrow(() -> new SeedException("Seed not found"));

		existSeed.setCommonName(updatedSeed.getCommonName());
		existSeed.setBloomTime(updatedSeed.getBloomTime());
		existSeed.setWatering(updatedSeed.getWatering());
		existSeed.setTypeOfSeeds(updatedSeed.getTypeOfSeeds());
		log.info("seed updated successfully");
        return sRepo.save(existSeed);
	}

	@Override
	public Seed deleteSeed(Integer seedId) throws SeedException {
		Optional<Seed> opt = sRepo.findById(seedId);
		if(opt.isPresent()) {
			sRepo.deleteById(seedId);
			log.info("seed deleted successfully");
			return opt.get();
		}else {
		
			throw new SeedException("Opps! Seed not found");
		}
	}

	@Override
	public Seed viewSeed(Integer seedId) throws SeedException {
		log.info("seed viewed successfully");
		 return sRepo.findById(seedId)
	                .orElseThrow(() -> new SeedException("Seed not found"));
	}

	@Override
	public Seed viewSeedByCommonName(String commonName) throws SeedException {
		Optional<Seed> s=sRepo.findByCommonName(commonName);
		if(s.isEmpty()) throw  new SeedException("Seed not found");
		Seed seed=s.get();
		log.info("seed viewed successfully");
		return seed;
	}

	@Override
	public List<Seed> viewAllseed() throws SeedException {
		Pageable p = PageRequest.of(0, 5, Sort.by("commonName").ascending()) ;
		List<Seed> seedList = sRepo.findAll(p).getContent() ;
    	if(seedList.isEmpty()) throw new SeedException("Empty Seed list") ;
    	log.info("seed viewed successfully");
    	return seedList ;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) {
        
        
        Pageable p= PageRequest.of(0, 5,Sort.by("typeOfSeed").ascending());
		
		Page<Seed> seeds=sRepo.findAll(p);
		
		if(seeds.isEmpty())throw new PlantException("No seed Found !!!");
		
		log.info("Seeds viewed Successfully");
		
		return seeds.toList();
	}

}
