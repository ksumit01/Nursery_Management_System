package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Min(value=1 ,message="minimum height should be 1")
private Integer plantheight;
@NotNull
@NotBlank
@NotEmpty
private String plantSpread;
@NotNull
@NotBlank
@NotEmpty
private String commonName;
@NotNull
@NotBlank
@NotEmpty
private String bloomTime;
@NotNull
@NotBlank
@NotEmpty
private String medicinalOrCulinaryUse;
@NotNull
@NotBlank
@NotEmpty
private String difficultyLevel;
@NotNull
@NotBlank
@NotEmpty
private String temperature;
@NotNull
@NotBlank
@NotEmpty
private String typeOfPlant;
@NotNull
@NotBlank
@NotEmpty
@Size(min = 10)
private String plantDescription;
@NotNull
@NotBlank
@NotEmpty
private Integer plantsStock;
@NotNull
private double plantCost;

@ManyToOne(cascade = CascadeType.ALL)
@JsonIgnore
private Orders orders;

@OneToOne(fetch = FetchType.EAGER)
private Planter planter;

}
