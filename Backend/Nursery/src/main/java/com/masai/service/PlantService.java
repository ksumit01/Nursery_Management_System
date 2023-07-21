package com.masai.service;

import java.util.List;

import com.masai.model.Plant;

public interface PlantService {
public Plant addPlant(Plant plant);
public Plant updatePlant(Plant plant);
public Plant deletePlant(Plant plant);
public Plant viewPlant(int plantId);
public Plant viewplant(String commonName);
public List<Plant> viewAllPlants();
public List<Plant> viewAllPlants(String typeOfplant);
}
