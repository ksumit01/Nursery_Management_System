package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Plant;
import com.masai.service.PlantServiceimpl;

import jakarta.validation.Valid;

@RestController
public class PlantController {
	@Autowired
	private PlantServiceimpl plantService;
	
	@PostMapping("/plantSave")
	public ResponseEntity<Plant> savePlantHandller(@Valid @RequestBody Plant plant) {
		
		Plant plantNew = plantService.addPlant(plant);
		
		return new ResponseEntity<>(plantNew, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/plantUpdate")
	public ResponseEntity<Plant> updatePlantHandller(@Valid @RequestBody Plant plant) {
		
		Plant plantNew = plantService.updatePlant(plant);
		
		return new ResponseEntity<>(plantNew, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/plantDelete/{plantId}")
	public ResponseEntity<Plant> DeletePlantHandller(@PathVariable Integer plantId) {
		
		Plant plantNew = plantService.deletePlant(plantId);
		
		return new ResponseEntity<>(plantNew, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/plantView/{plantId}")
	public ResponseEntity<Plant> viewPlantHandller(@PathVariable Integer plantId) {
		
		Plant plantNew = plantService.viewPlant(plantId);
		
		return new ResponseEntity<>(plantNew, HttpStatus.ACCEPTED);
	}

	@GetMapping("/plantViewByName/{commonName}")
	public ResponseEntity<Plant> viewPlantByNameHandller(@PathVariable String commonName) {
		
		Plant plantNew = plantService.viewplant(commonName);
		
		return new ResponseEntity<>(plantNew, HttpStatus.ACCEPTED);
	}

	@GetMapping("/plantViewByTypeOfPlant/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewPlantBytypeOfPlantHandller(@PathVariable String typeOfPlant) {
		
		List<Plant> plantNew = plantService.viewAllPlants(typeOfPlant);
		
		return new ResponseEntity<>(plantNew, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/plants")
	public ResponseEntity<List<Plant>> viewAllPlantHandller() {
		
		List<Plant> plantNew = plantService.viewAllPlants();
		
		return new ResponseEntity<>(plantNew, HttpStatus.ACCEPTED);
	}
}
