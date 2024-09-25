package pe.edu.cibertec.patitas_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PatitasBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatitasBackendApplication.class, args);
	}

}
