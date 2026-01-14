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
public class Mantenimiento {

    @Id
    @GeneratedValue
    private Long id;

    private String tipo;
    private LocalDate fecha;
    private int kmEnRevision;

    @ManyToOne
    @JoinColumn(name = "vehiculo",
            foreignKey = @ForeignKey(name = "fk_mantenimiento_vehiculo"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "taller",
            foreignKey =  @ForeignKey(name = "fk_mantenimiento_taller"))
    private Taller taller;
}
