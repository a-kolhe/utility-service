package com.working.utility_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.working.utility_service.dto.CitiDTO;
import com.working.utility_service.exception.UtilityException;

@Service
public interface AddressService {

	List<CitiDTO> getCityList(String input) throws UtilityException;
}
