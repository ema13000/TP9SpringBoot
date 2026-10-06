package TP.SpringBootGrupal.dtos;

import TP.SpringBootGrupal.entities.FacturaVenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaReporteDTO {
    Long numeroFactura;
    Date fechaEmision;
    String clienteDenominacion;
    String condicionIva;
    String puntoVentaDescripcion;
    double importeTotal;
    long cantidadItems;
}

