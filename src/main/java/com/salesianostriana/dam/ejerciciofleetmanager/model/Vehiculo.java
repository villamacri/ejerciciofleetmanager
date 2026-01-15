package com.salesianostriana.dam.ejerciciofleetmanager.model;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
@Entity
@Getter @Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Vehiculo {

    @Id
    @GeneratedValue
    private Long id;


    private String matricula;
    private String modelo;
    private int kmActuales;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToOne(mappedBy = "vehiculo")
    private Conductor conductor;

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Asignacion> asignaciones = new ArrayList<>();

    public void addAsignacion(Asignacion asignacion){
        asignaciones.add(asignacion);
        asignacion.setVehiculo(this);
    }

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    public void addMantenimiento(Mantenimiento mantenimiento){
        mantenimientos.add(mantenimiento);
        mantenimiento.setVehiculo(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return kmActuales == vehiculo.kmActuales && Objects.equals(id, vehiculo.id) && Objects.equals(matricula, vehiculo.matricula) && Objects.equals(modelo, vehiculo.modelo) && estado == vehiculo.estado && Objects.equals(asignaciones, vehiculo.asignaciones) && Objects.equals(mantenimientos, vehiculo.mantenimientos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matricula, modelo, kmActuales, estado, asignaciones, mantenimientos);
    }
}
