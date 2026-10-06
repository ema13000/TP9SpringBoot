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
@EqualsAndHashCode(callSuper = true, exclude = {"detalles"})

public class FacturaVenta extends AuditoriaApp {


    //cliente, cond iva y moneda @ManyToOne

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condicion_iva_id", nullable = false)
    private CondicionIva condicionIva;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_mondeda_id", nullable = false)
    private TipoMoneda tipoMoneda;
    @EqualsAndHashCode.Include
    private Long numero;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "punto_venta_id")
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

    @OneToMany (mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Builder.Default
    private List<FacturaVentaDetalle> detalles = new ArrayList<>();
}

