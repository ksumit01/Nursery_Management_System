package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingOrderId;
	@NotBlank
	private LocalDate orderDate;
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 50, message = "legth of transactionMode should be in the given range")
	private String transactionMode;
	@Positive(message = "quantity must be possitive")
	@NotNull(message = "quantity should not be null")
	private int quantity;
	@Positive(message = "totalCost must be possitive")
	@NotNull(message = "totalCost should not be null")
	private double totalCost;
	private List<Object> planterList = new ArrayList<>();
	
	
	public Orders(@NotBlank LocalDate orderDate,
			@NotNull @NotEmpty @Size(min = 2, max = 50, message = "legth of transactionMode should be in the given range") String transactionMode,
			@Positive(message = "quantity must be possitive") @NotNull(message = "quantity should not be null") int quantity,
			double totalCost, List<Object> planterList) {
		super();
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planterList = planterList;
	}
	
	
	public Orders(@NotBlank LocalDate orderDate,
			@NotNull @NotEmpty @Size(min = 2, max = 50, message = "legth of transactionMode should be in the given range") String transactionMode,
			@Positive(message = "quantity must be possitive") @NotNull(message = "quantity should not be null") int quantity,
			double totalCost) {
		super();
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}


	public Orders(
			@NotNull @NotEmpty @Size(min = 2, max = 50, message = "legth of transactionMode should be in the given range") String transactionMode,
			@Positive(message = "quantity must be possitive") @NotNull(message = "quantity should not be null") int quantity,
			double totalCost, List<Object> planterList) {
		super();
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planterList = planterList;
	}
	
	
	
}
