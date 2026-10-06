package TP.SpringBootGrupal;

import TP.SpringBootGrupal.dtos.FacturaReporteDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootGrupalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGrupalApplication.class, args);
	}
}
