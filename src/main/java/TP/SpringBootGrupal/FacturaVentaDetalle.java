package TP.SpringBootGrupal;

import lombok.*;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "DetalleVenta" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

public class FacturaVentaDetalle extends EntityId{
    @ManyToOne
    @JoinColumn(nullable = false)
    private FacturaVenta factura;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private ListaPrecioArticulo listaPrecioArticulo;
    private String descripcion;
    @Column(nullable = false)
    private double cantidad;
    @Column(nullable = false)
    private double precioUnitario;
    private double porcentajeBonificacion;
    private double importeNeto;
    private double importeIva;
    @Column(nullable = false)
    private double importeSubtotal;
}
