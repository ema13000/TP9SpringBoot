package TP.SpringBootGrupal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

    @Entity
    @Table(name = "Usuario")
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    public class Usuario extends EntityId {

        @Column(nullable = false)
        private String usuario;

        @Column(nullable = false)
        @ToString.Exclude
        private String clave;

        @Column(nullable = false)
        private String nombre;

        @Column(nullable = false)
        private String apellido;
    }
