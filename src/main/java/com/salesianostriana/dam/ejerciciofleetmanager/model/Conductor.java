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
public class Conductor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;

    @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Asignacion> asignaciones = new ArrayList<>();
}
