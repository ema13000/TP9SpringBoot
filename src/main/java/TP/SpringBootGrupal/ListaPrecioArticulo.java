package TP.SpringBootGrupal;

import lombok.*;
import lombok.experimental.SuperBuilder;


import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "lista_precio_articulo")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ListaPrecioArticulo extends AuditoriaApp {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private ListaPrecio listaPrecio;
    @Column(nullable = false)
    private double precioVenta;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Articulo articulo;
}
