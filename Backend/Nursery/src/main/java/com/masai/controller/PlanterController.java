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

import com.masai.exception.PlanterException;
import com.masai.model.Planter;
import com.masai.service.PlanterServiceImpl;

import jakarta.validation.Valid;

public class PlanterController {
	
	@Autowired 
	private PlanterServiceImpl Planterservice;
	/*
	{
		   "planterHeight":5.4,
		   "planterCapacity":7,
		   "drinageHole":9, 
		   "planterColor":"red",
		   "planterShape":"round",
		   "planterStock":80,
		   "planterCost":700,
		   "orders":{
		       "orderDate":"12/02/2023",
		       "transactionMode":"online",
		       "quantity":"2",
		       "totalCost":"7000.0"
		       
		   }
		}
	*/
	@PostMapping("/planters")
	public ResponseEntity<Planter> savePlanterHandller(@Valid @RequestBody Planter planter) throws PlanterException {
		
		Planter planter1 = Planterservice.addPlanter(planter);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/UpdatePlanter")
	public ResponseEntity<Planter> updatePlanterHandller(@Valid @RequestBody Planter planter) throws PlanterException {
		
		
		Planter planter1 = Planterservice.updatePlanter(planter);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/DeletePlanter/{planterid}")
	public ResponseEntity<Planter> DeletePlanterHandller(@PathVariable("planterid") Integer PlanterId) throws PlanterException {
		
		Planter planter1 = Planterservice.deletePlanter(PlanterId);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/ViewPlanter/{planterId}")
	public ResponseEntity<Planter> viewPlanterHandller(@PathVariable("planterId") Integer PlanterId) throws PlanterException {
		
		Planter planter1 = Planterservice.viewPlanter(PlanterId);
		
		return new ResponseEntity<>(planter1, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/ViewPlanterByShape/{Plantershape}")
	public ResponseEntity <List<Planter>> viewPlanterByShapeHandller(@PathVariable("Plantershape") String plantershape) throws PlanterException {
		
		List<Planter> planter = Planterservice.viewPlanter(plantershape);
		
		return new ResponseEntity<>(planter, HttpStatus.ACCEPTED);
	}

	@GetMapping("/plantViewType/{mincost}/{maxcost}")
	public ResponseEntity<List<Planter>> viewPlanterByCostPlantHandller(@PathVariable("mincost") double minCost,@PathVariable("maxcost") double maxCost) throws PlanterException {
		
		List<Planter> planters = Planterservice.viewAllPlanters(minCost, maxCost);
		
		return new ResponseEntity<>(planters, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/ViewAllPlanters")
	public ResponseEntity<List<Planter>> viewAllPlantHandller() throws PlanterException {
		
		List<Planter> planters = Planterservice.viewAllPlanters();
		
		return new ResponseEntity<>(planters, HttpStatus.ACCEPTED);
	}
}
