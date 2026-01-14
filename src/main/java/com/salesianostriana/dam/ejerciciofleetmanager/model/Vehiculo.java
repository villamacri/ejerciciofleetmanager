package com.salesianostriana.dam.ejerciciofleetmanager.model;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.util.ArrayList;
import java.util.List;

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
    private Estado estado;

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    private List<Asignacion> asignaciones = new ArrayList<>();

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    //Métodos helper
    public void addAsignacion(Asignacion asignacion){
        asignaciones.add(asignacion);
        asignacion.setVehiculo(this);
    }

    public void removeAsignacion(Asignacion asignacion){
        asignaciones.remove(asignacion);
        asignacion.setVehiculo(null);
    }
}
