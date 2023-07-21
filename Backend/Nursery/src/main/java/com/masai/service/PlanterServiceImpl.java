package com.masai.service;


import com.masai.exception.PlanterException;
import com.masai.model.Planter;
import com.masai.repository.Planterrepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlanterServiceImpl implements PlanterService {


    @Autowired
    private Planterrepository planterRepo;



    public Planter addPlanter(Planter planter) throws PlanterException {

        log.info("planter added successfully");

        if(planter==null) throw new PlanterException("planter details are not valid");

            Optional<Planter> newPlanter = planterRepo.findById(planter.getPlanterId());

         if(newPlanter.isPresent()) throw new PlanterException("this planter is already Existed");


        planterRepo.save(planter);

        return planter;

    }

    @Override
    public Planter updatePlanter(Planter planter) throws PlanterException {

        log.info("planter updated successfully");

        if(planter==null)throw new PlanterException("Planter details are not valid !!!");

        Optional<Planter> newPlanter= planterRepo.findById(planter.getPlanterId());

        if(!newPlanter.isPresent()) throw new PlanterException("This Planter is Not Existed !!!");

        planterRepo.save(planter);

        return planter;



    }

    @Override
    public Planter deletePlanter(Integer planterId) throws PlanterException {

        log.info("Plant Deleted Successfully");

        if(planterId==null)throw new PlanterException("Planter details are not valid");

        Optional<Planter> newPlanter= planterRepo.findById(planterId);

        if(!newPlanter.isPresent()) throw new PlanterException("This planter does not exist");

        Planter planter= newPlanter.get();

        planterRepo.delete(planter);

        return planter;



    }

    @Override
    public Planter viewPlanter(Integer planterId) throws PlanterException {

        log.info("Planter viewed Successfully");

        Optional<Planter> newPlanter= planterRepo.findById(planterId);

        if(newPlanter==null)throw new PlanterException("planter details are not valid");

        if(!newPlanter.isPresent())throw new PlanterException("This planter does not existed !!!");

        Planter planter=newPlanter.get();

        return planter;


    }


    @Override
    public List<Planter> viewPlanter(String planterShape) throws PlanterException {

        log.info("Planter viewed Successfully");

        List<Planter> newPlanter= planterRepo.findByPlanterShape(planterShape);

        if(newPlanter==null)throw new PlanterException("planter details are not valid");

        if(!newPlanter.isEmpty())throw new PlanterException("This planter does not exist");

        return newPlanter;

    }

    @Override
    public List<Planter> viewAllPlanters() throws PlanterException {

        log.info("Planters viewed Successfully");

        Pageable page= PageRequest.of(0, 5, Sort.by("planterId").ascending());

        Page<Planter> Planters= planterRepo.findAll(page);

        if(Planters.isEmpty())throw new PlanterException("No Plant Found !!!");

        return Planters.toList();




    }

    @Override
    public List<Planter> viewAllPlanters(double minCost, double maxCost) throws PlanterException {

        log.info("Plants viewed Successfully");

        List<Planter> allPlanters = planterRepo.findByPlanterCostBetween(minCost, maxCost);

        if(allPlanters.isEmpty())throw new PlanterException("No Plant Found for given cost !");


        return allPlanters;
    }




}
