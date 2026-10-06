package TP.SpringBootGrupal;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;


@Entity
@Table (name = "CondicionIva")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

public class CondicionIva extends AuditoriaApp{
        @Column(nullable = false)
        @EqualsAndHashCode.Include
        private int codigoAfip;
        @Column(nullable = false)
        private String denominacion;
}
