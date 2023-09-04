package com.Egabi.drones;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityNotFoundException;


@SpringBootApplication
public class DronesApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DronesApplication.class);
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DronesApplication.class, args);

	}

}
