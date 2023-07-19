package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer plantId;
@NotNull
@Min(value=1)
private Integer plantheight;
private String plantSpread;
private String commonName;
private String bloomTime;
private String medicinalOrCulinaryUse;
private String difficultyLevel;
private String temperature;
private String typeOfPlant;
private String plantDescription;
private Integer plantsStock;
private double plantCost;

}
