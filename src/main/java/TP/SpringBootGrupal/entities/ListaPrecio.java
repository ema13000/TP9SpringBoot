package TP.SpringBootGrupal.entities;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "lista_precio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ListaPrecio extends AuditoriaApp {
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String codigo;
    @Column(nullable = false)
    private String denominacion;

}
