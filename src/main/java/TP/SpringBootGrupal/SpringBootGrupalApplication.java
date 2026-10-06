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

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpJPA");
	EntityManager em = emf.createEntityManager();

	String jpql = "SELECT new com.ejemplo.dto.FacturaReporteDTO(" +
			"   f.numero, " +
			"   f.fechaEmision, " +
			"   COALESCE(c.denominacion, 'Consumidor Final'), " +
			"   ci.denominacion, " +
			"   pv.descripcion, " +
			"   f.importeTotal, " +
			"   COUNT(d) " +
			") " +
			"FROM FacturaVenta f " +
			"LEFT JOIN f.cliente c " +
			"JOIN f.condicionIva ci " +
			"JOIN f.puntoVenta pv " +
			"JOIN f.detalles d " +
			"GROUP BY f.id, f.numero, f.fechaEmision, " +
			"c.denominacion, ci.denominacion, " +
			"pv.descripcion, f.importeTotal";

	List<FacturaReporteDTO> reporte = em
			.createQuery(jpql, FacturaReporteDTO.class)
			.getResultList();

}
