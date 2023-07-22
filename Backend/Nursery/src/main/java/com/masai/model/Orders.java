package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Planter> planterList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Plant> plantList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Seed> seedList = new ArrayList<>();
	
	
	public Orders(@NotBlank LocalDate orderDate,
			@NotNull @NotEmpty @Size(min = 2, max = 50, message = "legth of transactionMode should be in the given range") String transactionMode,
			@Positive(message = "quantity must be possitive") @NotNull(message = "quantity should not be null") int quantity,
			@Positive(message = "totalCost must be possitive") @NotNull(message = "totalCost should not be null") double totalCost,
			List<Planter> planterList, List<Plant> plantList, List<Seed> seedList) {
		super();
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.planterList = planterList;
		this.plantList = plantList;
		this.seedList = seedList;
	}
	public Orders(int bookingOrderId, @NotBlank LocalDate orderDate,
			@NotNull @NotEmpty @Size(min = 2, max = 50, message = "legth of transactionMode should be in the given range") String transactionMode,
			@Positive(message = "quantity must be possitive") @NotNull(message = "quantity should not be null") int quantity,
			@Positive(message = "totalCost must be possitive") @NotNull(message = "totalCost should not be null") double totalCost) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	
	
	
	
}
