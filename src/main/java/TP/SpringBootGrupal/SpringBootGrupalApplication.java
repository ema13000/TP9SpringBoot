package TP.SpringBootGrupal;

import TP.SpringBootGrupal.entities.*;
import TP.SpringBootGrupal.repository.FacturaVentaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

@SpringBootApplication
public class SpringBootGrupalApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(
						SpringBootGrupalApplication.class,
						args
				);

		FacturaVentaRepository facturaRepository =
				context.getBean(FacturaVentaRepository.class);

		EntityManagerFactory entityManagerFactory =
				context.getBean(EntityManagerFactory.class);

		PlatformTransactionManager transactionManager =
				context.getBean(PlatformTransactionManager.class);

		TransactionTemplate transaccion =
				new TransactionTemplate(transactionManager);

		transaccion.executeWithoutResult(status -> {

			if (facturaRepository.count() > 0) {
				return;
			}

			EntityManager em =
					EntityManagerFactoryUtils
							.getTransactionalEntityManager(
									entityManagerFactory
							);

			if (em == null) {
				throw new IllegalStateException(
						"No se pudo obtener el EntityManager de la transacción."
				);
			}

			Usuario usuario = new Usuario();
			usuario.setUsuario("usuario-prueba");
			usuario.setClave("solo-prueba");
			usuario.setNombre("Usuario");
			usuario.setApellido("Prueba");
			em.persist(usuario);

			CondicionIva condicionIva = new CondicionIva();
			condicionIva.setCodigoAfip(5);
			condicionIva.setDenominacion("Consumidor Final");
			completarAuditoria(condicionIva, usuario);
			em.persist(condicionIva);

			TipoMoneda moneda = new TipoMoneda();
			moneda.setCodigoAfip("PES");
			moneda.setDenominacion("Peso argentino");
			moneda.setSimbolo("$");
			completarAuditoria(moneda, usuario);
			em.persist(moneda);

			PuntoVenta puntoVenta = new PuntoVenta();
			puntoVenta.setNumero(1);
			puntoVenta.setDescripcion("Sucursal Central");
			completarAuditoria(puntoVenta, usuario);
			em.persist(puntoVenta);

			Articulo articulo = new Articulo();
			articulo.setCodigo("ART-001");
			articulo.setDenominacion("Artículo de prueba");
			completarAuditoria(articulo, usuario);
			em.persist(articulo);

			ListaPrecio lista = new ListaPrecio();
			lista.setCodigo("LP-001");
			lista.setDenominacion("Lista general");
			completarAuditoria(lista, usuario);
			em.persist(lista);

			ListaPrecioArticulo precio = new ListaPrecioArticulo();
			precio.setArticulo(articulo);
			precio.setListaPrecio(lista);
			precio.setPrecioVenta(1500);
			completarAuditoria(precio, usuario);
			em.persist(precio);

			FacturaVenta factura = new FacturaVenta();
			factura.setNumero(1001L);
			factura.setFechaEmision(new Date());
			factura.setCliente(null);
			factura.setCondicionIva(condicionIva);
			factura.setTipoMoneda(moneda);
			factura.setPuntoVenta(puntoVenta);
			factura.setEstado("EMITIDA");
			factura.setImporteTotal(3000);
			factura.setImporteCobrado(0);
			factura.setImporteSaldo(3000);
			completarAuditoria(factura, usuario);

			FacturaVentaDetalle detalle = new FacturaVentaDetalle();
			detalle.setListaPrecioArticulo(precio);
			detalle.setDescripcion("Artículo de prueba");
			detalle.setCantidad(2);
			detalle.setPrecioUnitario(1500);
			detalle.setPorcentajeBonificacion(0);
			detalle.setImporteNeto(3000);
			detalle.setImporteIva(0);
			detalle.setImporteSubtotal(3000);

			detalle.setFactura(factura);
			factura.getDetalles().add(detalle);

			facturaRepository.save(factura);
			em.flush();
		});

		System.out.println("Carga inicial finalizada.");
	}

	private static void completarAuditoria(
			AuditoriaApp entidad,
			Usuario usuario
	) {
		Date ahora = new Date();

		entidad.setFechaAlta(ahora);
		entidad.setFechaModificacion(ahora);
		entidad.setUsuarioCarga(usuario);
		entidad.setUsuarioModificacion(usuario);
	}
}