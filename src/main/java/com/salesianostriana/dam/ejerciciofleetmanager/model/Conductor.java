package com.salesianostriana.dam.ejerciciofleetmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Conductor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Asignacion> asignaciones = new HashSet<>();

    public void addAsignacion(Asignacion asignacion){
        asignaciones.add(asignacion);
        asignacion.setConductor(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conductor conductor = (Conductor) o;
        return Objects.equals(id, conductor.id) && Objects.equals(nombre, conductor.nombre) && Objects.equals(email, conductor.email) && Objects.equals(vehiculo, conductor.vehiculo) && Objects.equals(asignaciones, conductor.asignaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, vehiculo, asignaciones);
    }
}
