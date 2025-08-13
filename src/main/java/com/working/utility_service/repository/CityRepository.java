package com.working.utility_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.working.utility_service.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	@Query("SELECT c FROM City c JOIN FETCH c.state " +
		       "WHERE LOWER(c.name) LIKE LOWER(CONCAT( :input, '%')) " +
		       "OR LOWER(c.state.name) LIKE LOWER(CONCAT( :input,'%'))")

	List<City> getCitiesByCityMatchLikeOrStateName(@Param("input") String input);
}
