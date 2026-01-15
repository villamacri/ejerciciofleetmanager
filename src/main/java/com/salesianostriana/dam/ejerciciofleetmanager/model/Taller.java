package com.salesianostriana.dam.ejerciciofleetmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ToString
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
    @Builder.Default
    private List<Mantenimiento> mantenimientos=new ArrayList<>();

    //Métodos helper
    public void addMantenimento(Mantenimiento mantenimiento){
        mantenimientos.add(mantenimiento);
        mantenimiento.setTaller(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Taller taller = (Taller) o;
        return Objects.equals(id, taller.id) && Objects.equals(nombre, taller.nombre) && Objects.equals(ciudad, taller.ciudad) && Objects.equals(mantenimientos, taller.mantenimientos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, ciudad, mantenimientos);
    }
}
