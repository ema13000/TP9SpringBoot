package TP.SpringBootGrupal;

import jakarta.persistence.*;
import java.util.Date;
import lombok.experimental.SuperBuilder;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@MappedSuperclass
public abstract class AuditoriaApp extends EntityId {
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaAlta;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaBaja;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaModificacion;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    protected Usuario usuarioCarga;
    @ManyToOne
    protected Usuario usuarioBaja;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    protected Usuario usuarioModificacion;
}
