package com.working.utility_service.dto;

import com.working.utility_service.entities.States;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitiDTO {

	private Long id;

	private String name;

	private StateDTO state;

	private String type;

	private String stateName;

	private Long population;

	private String populationClass;
}
