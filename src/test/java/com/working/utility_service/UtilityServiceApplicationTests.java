package com.working.utility_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.working.utility_service.entities.City;
import com.working.utility_service.entities.States;

@SpringBootTest(classes = {States.class, City.class})
@EntityScan(basePackages = "com.working.utility_service.entities")
class UtilityServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
