package com.working.utility_service.entities;

import com.working.utility_service.dto.CitiDTO;
import com.working.utility_service.dto.StateDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private States state;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "state_name")
	private String stateName;
	
	@Column(name = "population")
	private Long population;
	
	@Column(name = "population_class")
	private String populationClass;

	public CitiDTO convertToDTO() {
		CitiDTO city = new CitiDTO();
		city.setId(this.getId());
		city.setName(this.getName());
		city.setType(this.getType());
		city.setStateName(this.getStateName());
		city.setPopulation(this.getPopulation());
		city.setPopulationClass(this.getPopulationClass());
		StateDTO s = new StateDTO();
		s.setId(this.getState().getId());
		s.setName(this.getState().getName());
		city.setState(s);
		return city;
	}
	
	
}
