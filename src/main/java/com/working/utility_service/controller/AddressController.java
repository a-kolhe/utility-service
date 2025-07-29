package com.working.utility_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.utility_service.dto.CitiDTO;
import com.working.utility_service.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/getCities/{searchTxt}")
	public List<CitiDTO> getCities(@PathVariable("searchTxt") String input){
		
		return addressService.getCityList(input);
	}
}
