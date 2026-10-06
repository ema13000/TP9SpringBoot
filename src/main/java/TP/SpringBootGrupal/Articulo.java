package TP.SpringBootGrupal;

import jakarta.persistence.*;
import lombok.*;

import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Articulo")
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Articulo extends AuditoriaApp{
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Rubro rubro;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private String denominacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Marca marca;
}
