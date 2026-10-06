package TP.SpringBootGrupal.entities;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Marca")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)

public class Marca extends AuditoriaApp{
    @Column(nullable = false)
    private String denominacion;
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private Integer codigo;
}
