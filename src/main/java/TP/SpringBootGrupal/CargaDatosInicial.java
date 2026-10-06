package TP.SpringBootGrupal;

import TP.SpringBootGrupal.entities.*;
import TP.SpringBootGrupal.repository.FacturaVentaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class CargaDatosInicial implements CommandLineRunner {

    private final FacturaVentaRepository facturaRepository;

    @PersistenceContext
    private EntityManager em;

    public CargaDatosInicial(
            FacturaVentaRepository facturaRepository
    ) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {

        // Si ya hay facturas, no repite la carga.
        if (facturaRepository.count() > 0) {
            return;
        }

        // 1. Usuario para completar la auditoría.
        Usuario usuario = new Usuario();
        usuario.setUsuario("usuario-prueba");
        usuario.setClave("solo-prueba");
        usuario.setNombre("Usuario");
        usuario.setApellido("Prueba");
        em.persist(usuario);

        // 2. Condición IVA.
        CondicionIva condicionIva = new CondicionIva();
        condicionIva.setCodigoAfip(5);
        condicionIva.setDenominacion("Consumidor Final");
        completarAuditoria(condicionIva, usuario);
        em.persist(condicionIva);

        // 3. Moneda.
        TipoMoneda moneda = new TipoMoneda();
        moneda.setCodigoAfip("PES");
        moneda.setDenominacion("Peso argentino");
        moneda.setSimbolo("$");
        completarAuditoria(moneda, usuario);
        em.persist(moneda);

        // 4. Punto de venta.
        PuntoVenta puntoVenta = new PuntoVenta();
        puntoVenta.setNumero(1);
        puntoVenta.setDescripcion("Sucursal Central");
        completarAuditoria(puntoVenta, usuario);
        em.persist(puntoVenta);

        // 5. Artículo.
        Articulo articulo = new Articulo();
        articulo.setCodigo("ART-001");
        articulo.setDenominacion("Artículo de prueba");
        completarAuditoria(articulo, usuario);
        em.persist(articulo);

        // 6. Lista de precios.
        ListaPrecio lista = new ListaPrecio();
        lista.setCodigo("LP-001");
        lista.setDenominacion("Lista general");
        completarAuditoria(lista, usuario);
        em.persist(lista);

        // 7. Precio del artículo.
        ListaPrecioArticulo precio = new ListaPrecioArticulo();
        precio.setArticulo(articulo);
        precio.setListaPrecio(lista);
        precio.setPrecioVenta(1500);
        completarAuditoria(precio, usuario);
        em.persist(precio);

        // 8. Factura.
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

        // 9. Detalle: dos unidades a 1500 cada una.
        FacturaVentaDetalle detalle = new FacturaVentaDetalle();
        detalle.setListaPrecioArticulo(precio);
        detalle.setDescripcion("Artículo de prueba");
        detalle.setCantidad(2);
        detalle.setPrecioUnitario(1500);
        detalle.setPorcentajeBonificacion(0);
        detalle.setImporteNeto(3000);
        detalle.setImporteIva(0);
        detalle.setImporteSubtotal(3000);

        // Se vinculan la factura y su detalle.
        detalle.setFactura(factura);
        factura.getDetalles().add(detalle);

        // Guarda la factura y, por cascada, su detalle.
        facturaRepository.save(factura);
        em.flush();

        System.out.println("Factura de prueba guardada.");
    }

    private void completarAuditoria(
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