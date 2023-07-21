package com.masai.repository;

import com.masai.model.Planter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface Planterrepository extends JpaRepository<Planter,Integer>, PagingAndSortingRepository<Planter,Integer> {

   public List<Planter> findByPlanterShape(String planterShape);
   public  List<Planter> findByPlanterCostBetween(Double min,Double max);


}
