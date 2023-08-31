package com.Egabi.drones;

import com.Egabi.drones.models.Medication;
import com.Egabi.drones.pojos.MedicationPOJO;
import com.Egabi.drones.repositories.MedicationRepo;
import com.Egabi.drones.services.MedicationService;
import com.Egabi.drones.utils.BasicHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DronesApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DronesApplication.class, args);

	}

}
