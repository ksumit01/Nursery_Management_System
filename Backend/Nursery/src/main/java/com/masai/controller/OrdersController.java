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

import com.masai.model.Orders;
import com.masai.service.OrdersService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrdersController {
	
	@Autowired
	private OrdersService oredrSer;
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrders(@Valid @RequestBody Orders orders){
		log.info("Adding new Orders");
		return new ResponseEntity<>(oredrSer.addOrders(orders), HttpStatus.CREATED);
	}
	
	@PutMapping("/orders")
	public ResponseEntity<Orders> updateOrders(@Valid @RequestBody Orders orders){
		log.info("updating Orders details");
		return new ResponseEntity<>(oredrSer.updateOrders(orders), HttpStatus.OK);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<Orders> deleteOrders(@PathVariable Integer orderId){
		log.info("Deleting Orders");
		return new ResponseEntity<>(oredrSer.deleteOrders(orderId), HttpStatus.OK);
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Orders> viewOrders(@PathVariable Integer orderId){
		log.info("getting Orders by using order id");
		return new ResponseEntity<>(oredrSer.viewOrders(orderId), HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> viewAllOrders(){
		log.info("getting all Orders");
		return new ResponseEntity<>(oredrSer.viewAllOrders(), HttpStatus.OK);
	}

}
