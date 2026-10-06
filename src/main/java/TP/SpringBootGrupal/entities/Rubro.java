package TP.SpringBootGrupal.entities;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Rubro")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)

public class Rubro extends AuditoriaApp{
    @Column(nullable = false)
    private String denominacion;
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Integer codigo;
}
