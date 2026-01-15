package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Asignacion;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Conductor;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;

public record VehiculoSummaryDto(
        Long id,
        String matricula,
        String modelo,
        Estado estado,
        ConductorSimpleDto conductorSimpleDto
) {

    public record ConductorSimpleDto(Long id, String nombre){}

    public static VehiculoSummaryDto of(Vehiculo v){
        return new VehiculoSummaryDto(
                v.getId(),
                v.getMatricula(),
                v.getModelo(),
                v.getEstado(),
                new ConductorSimpleDto(v.getConductor().getId(), v.getConductor().getNombre())
         );
    }
}
