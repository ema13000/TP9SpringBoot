package TP.SpringBootGrupal;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Domicilio extends EntityId {
    private String nombreCalle;
    private String numeroCalle;
}
