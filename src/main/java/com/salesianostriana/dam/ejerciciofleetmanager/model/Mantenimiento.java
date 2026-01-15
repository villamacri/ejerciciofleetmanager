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
public class Mantenimiento {

    @Id
    @GeneratedValue
    private Long id;

    private String tipo;
    private LocalDate fecha;
    private int kmEnRevision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo",
            foreignKey = @ForeignKey(name = "fk_mantenimiento_vehiculo"))
    private Vehiculo vehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taller",
            foreignKey =  @ForeignKey(name = "fk_mantenimiento_taller"))
    private Taller taller;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mantenimiento that = (Mantenimiento) o;
        return kmEnRevision == that.kmEnRevision && Objects.equals(id, that.id) && Objects.equals(tipo, that.tipo) && Objects.equals(fecha, that.fecha) && Objects.equals(vehiculo, that.vehiculo) && Objects.equals(taller, that.taller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, fecha, kmEnRevision, vehiculo, taller);
    }
}
