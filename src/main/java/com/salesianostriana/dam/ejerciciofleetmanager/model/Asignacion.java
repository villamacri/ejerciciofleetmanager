package com.salesianostriana.dam.ejerciciofleetmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@ToString
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo",
            foreignKey = @ForeignKey(name = "fk_asignacion_vehiculo"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "conductor",
            foreignKey = @ForeignKey(name = "fk_asignacion_conductor"))
    private Conductor conductor;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Asignacion that = (Asignacion) o;
        return Objects.equals(id, that.id) && Objects.equals(fechaInicio, that.fechaInicio) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(vehiculo, that.vehiculo) && Objects.equals(conductor, that.conductor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInicio, fechaFin, vehiculo, conductor);
    }
}
