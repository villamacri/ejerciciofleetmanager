package com.salesianostriana.dam.ejerciciofleetmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Asignacion {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "vehiculo",
            foreignKey = @ForeignKey(name = "fk_asignacion_vehiculo"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "conductor",
            foreignKey = @ForeignKey(name = "fk_asignacion_conductor"))
    private Conductor conductor;

}
