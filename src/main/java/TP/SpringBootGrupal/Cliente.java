package TP.SpringBootGrupal;

import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@SuperBuilder
public class Cliente extends AuditoriaApp {
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String cuitCuil;
    @Column(nullable = false)
    private String denominacion;
    @OneToOne
    @JoinColumn(name = "contacto_id", nullable = false)
    private Contacto contacto;
    @OneToOne
    @JoinColumn(name= "domicilio_id", nullable = false)
    private Domicilio domicilio;
}
