package pe.edu.cibertec.patitas_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pe.edu.cibertec.patitas_backend.service.AutenticacionService;

@SpringBootApplication
public class PatitasBackendApplication {

	@Autowired
	AutenticacionService autenticacionService;
	public static void main(String[] args) {

		SpringApplication.run(PatitasBackendApplication.class, args);
	}

}
