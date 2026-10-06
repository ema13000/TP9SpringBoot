package TP.SpringBootGrupal;


import lombok.*;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name= "factura_venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

public class FacturaVenta extends AuditoriaApp {


    //cliente, cond iva y moneda @ManyToOne

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private CondicionIva condicionIva;
    @ManyToOne
    private TipoMoneda tipoMoneda;
    @EqualsAndHashCode.Include
    private Long numero;
    @Column(nullable = false)
    private Date fechaEmision;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private PuntoVenta puntoVenta;
    private double importeCobrado;
    private double importeSaldo;

    @Column (nullable = false)
    private double importeTotal;
    private String cae;
    private Date caeFechaVencimiento;
    private String resultadoAfip;
    private String motivoRechazo;

    @Column(nullable = false)
    private String estado;
    private Date fechaAnulacion;
    private String observaciones;

    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL)
    @ToString.Exclude
    @Builder.Default
    private List<FacturaVentaDetalle> detalles = new ArrayList<>();
}

