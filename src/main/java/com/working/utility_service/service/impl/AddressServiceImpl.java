package com.working.utility_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.utility_service.dto.CitiDTO;
import com.working.utility_service.entities.City;
import com.working.utility_service.exception.UtilityException;
import com.working.utility_service.repository.CityRepository;
import com.working.utility_service.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<CitiDTO> getCityList(String input) throws UtilityException {
		
		List<City> cities = cityRepository.getCitiesByCityMatchLikeOrStateName(input);
		if(!cities.isEmpty()) {
			return cities.stream().map(c -> c.convertToDTO()).collect(Collectors.toList());
		}else {
			throw new UtilityException("No matching city found");
		}
		
	}
	
	

}
