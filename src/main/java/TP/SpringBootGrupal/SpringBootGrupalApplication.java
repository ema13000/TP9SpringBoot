package TP.SpringBootGrupal;

import TP.SpringBootGrupal.dtos.FacturaReporteDTO;
import TP.SpringBootGrupal.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootGrupalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGrupalApplication.class, args);

				EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpJPA");
				EntityManager em = emf.createEntityManager();

				Usuario usuario = Usuario.builder()
						.usuario("sofiindovino")
						.clave("123456")
						.nombre("Sofía")
						.apellido("Indovino")
						.build();

				PuntoVenta puntoVenta = PuntoVenta.builder()
						.numero(1)
						.descripcion("Sucursal Central Mendoza")
						.tipoEmision("Electrónica")
						.domicilioComercial("Av. España 1234")
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				Rubro rubro = Rubro.builder()
						.codigo(10)
						.denominacion("Informática")
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				Marca marca = Marca.builder()
						.codigo(100)
						.denominacion("Logitech")
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				Articulo articulo = Articulo.builder()
						.codigo("ART-001")
						.denominacion("Teclado Mecánico RGB")
						.rubro(rubro)
						.marca(marca)
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				Articulo articulo2 = Articulo.builder()
						.codigo("ART-002")
						.denominacion("Mouse Inalámbrico Vertical")
						.rubro(rubro)
						.marca(marca)
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				ListaPrecio listaPrecio = ListaPrecio.builder()
						.codigo("LP-CONTADO")
						.denominacion("Lista Contado Publico")
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				ListaPrecioArticulo listaPrecioArticulo = ListaPrecioArticulo.builder()
						.listaPrecio(listaPrecio)
						.articulo(articulo)
						.precioVenta(25000.0)
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				ListaPrecioArticulo listaPrecioArticulo2 = ListaPrecioArticulo.builder()
						.listaPrecio(listaPrecio)
						.articulo(articulo2)
						.precioVenta(10000.0)
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				FacturaVenta facturaVenta = FacturaVenta.builder()
						.numero(10001L)
						.fechaEmision(java.sql.Date.valueOf(LocalDate.now()))
						.puntoVenta(puntoVenta)
						.importeCobrado(30250.0)
						.importeSaldo(0.0)
						.importeTotal(30250.0)
						.cae("74125896325814")
						.caeFechaVencimiento(java.sql.Date.valueOf(LocalDate.now().plusDays(10)))
						.resultadoAfip("A")
						.estado("EMITIDA")
						.observaciones("Venta efectuada con éxito")
						.detalles(new ArrayList<>())
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				FacturaVentaDetalle detalle1 = FacturaVentaDetalle.builder()
						.listaPrecioArticulo(listaPrecioArticulo)
						.descripcion("Teclado Mecánico RGB")
						.cantidad(1.0)
						.precioUnitario(25000.0)
						.porcentajeBonificacion(0.0)
						.importeNeto(25000.0)
						.importeIva(5250.0)
						.importeSubtotal(30250.0)
						.build();

				FacturaVentaDetalle detalle2 = FacturaVentaDetalle.builder()
						.listaPrecioArticulo(listaPrecioArticulo2)
						.descripcion("Mouse Inalámbrico Vertical")
						.cantidad(2.0)
						.precioUnitario(10000.0)
						.porcentajeBonificacion(0.0)
						.importeNeto(20000.0)
						.importeIva(4200.0)
						.importeSubtotal(24200.0)
						.build();

				Contacto contactoCliente = Contacto.builder()
						.email("ventas@electromendoza.com")
						.telefono("0261-4567890")
						.celular("2615551234")
						.build();

				Domicilio domicilioCliente = Domicilio.builder()
						.nombreCalle("San Martín")
						.numeroCalle("1250")
						.build();

				Cliente cliente = Cliente.builder()
						.cuitCuil("20-30123456-7")
						.denominacion("Electro Mendoza")
						.contacto(contactoCliente)
						.domicilio(domicilioCliente)
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				FacturaVenta facturaVenta2 = FacturaVenta.builder()
						.numero(10001L)
						.fechaEmision(java.sql.Date.valueOf(LocalDate.now()))
						.puntoVenta(puntoVenta)
						.importeCobrado(30255.0)
						.importeSaldo(0.0)
						.importeTotal(30255.0)
						.cae("74125896325814")
						.caeFechaVencimiento(java.sql.Date.valueOf(LocalDate.now().plusDays(10)))
						.resultadoAfip("A")
						.estado("EMITIDA")
						.observaciones("Venta efectuada con éxito")
						.detalles(new ArrayList<>())
						.fechaAlta(new Date())
						.fechaModificacion(new Date())
						.usuarioCarga(usuario)
						.usuarioModificacion(usuario)
						.build();

				detalle1.setFactura(facturaVenta);
				detalle2.setFactura(facturaVenta);

				facturaVenta.getDetalles().add(detalle1);
				facturaVenta.getDetalles().add(detalle2);

				facturaVenta.setImporteTotal(54450.0);
				facturaVenta.setImporteCobrado(54450.0);

				facturaVenta2.setImporteTotal(60000.0);
				facturaVenta2.setImporteCobrado(60000.0);

				em.getTransaction().begin();
				em.persist(facturaVenta);

				em.persist(contactoCliente);
				em.persist(domicilioCliente);
				em.persist(cliente);
				em.persist(facturaVenta2);

				em.getTransaction().commit();
				em.close();
				emf.close();
	}
}