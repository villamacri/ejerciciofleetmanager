package com.salesianostriana.dam.ejerciciofleetmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Taller {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String ciudad;

    @OneToMany(mappedBy = "taller", fetch = FetchType.LAZY)
    private List<Mantenimiento> mantenimientos=new ArrayList<>();

    //Métodos helper
    public void addMantenimento(Mantenimiento mantenimiento){
        mantenimientos.add(mantenimiento);
        mantenimiento.setTaller(this);
    }

    public void removeMantenimiento(Mantenimiento mantenimiento){
        mantenimientos.remove(mantenimiento);
        mantenimiento.setTaller(null);
    }
}
