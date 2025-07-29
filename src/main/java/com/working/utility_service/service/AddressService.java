package com.working.utility_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.working.utility_service.dto.CitiDTO;

@Service
public interface AddressService {

	List<CitiDTO> getCityList(String input);
}
