package TP.SpringBootGrupal;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="contacto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)

public class Contacto extends EntityId {
    private String email;
    private String telefono;
    @EqualsAndHashCode.Include
    private String celular;
}
