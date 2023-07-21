package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.service.SeedService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
public class SeedController {
	@Autowired 
	  private SeedService sService;
	
	@PostMapping("/seeds")
	  public ResponseEntity<Seed> addseeds(@Valid @RequestBody Seed seed){
		  Seed addSeed = sService.addSeed(seed);
		  return new ResponseEntity<Seed>(addSeed,HttpStatus.ACCEPTED);
	  }
	  
	  @PutMapping("/seeds/{seedId}")
	  public ResponseEntity<Seed> updateSeed(
	          @PathVariable("seedId") Integer seedId,
	           @RequestBody Seed updatedSeed) 
	  {
	      Seed updated = sService.updateSeed(seedId, updatedSeed);
	      return ResponseEntity.ok(updated);
	  }
	  
	  @DeleteMapping("/seed/{seedId}")
	  public ResponseEntity<Seed> deleteSeed(@PathVariable("seedId") Integer seedId) {
	      Seed s=sService.deleteSeed(seedId);
	      return new ResponseEntity<>(s,HttpStatus.OK);
	  }

	  @GetMapping("/seedId/{seedId}")
	  public ResponseEntity<Seed> viewSeed(@PathVariable("seedId") Integer seedId) {
	      Seed seed = sService.viewSeed(seedId);
	      return ResponseEntity.ok(seed);
	  }
	  
	  @GetMapping("/seeds")
	  public ResponseEntity<List<Seed>> viewAllSeed() {
	      List<Seed> seeds = sService.viewAllseed();
	      return ResponseEntity.ok(seeds);
	  }
	  
	  @GetMapping("/seed/{commonName}")
	  public ResponseEntity<Seed> viewSeed(@PathVariable("commonName") String commonName) {
	      Seed seed = sService.viewSeedByCommonName(commonName);
	      return ResponseEntity.ok(seed);
	  }
	  
	  @GetMapping("/plantViewByTypeOfSeed/{typeOfSeed}")
		public ResponseEntity<List<Seed>> viewPlantBytypeOfSeedHandller(@PathVariable String typeOfSeed) {
			
			List<Seed> seeds = sService.viewAllSeeds(typeOfSeed);
			
			return new ResponseEntity<>(seeds, HttpStatus.ACCEPTED);
		}
}
