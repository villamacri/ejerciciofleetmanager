package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Asignacion;

import java.time.LocalDate;

public record AsignacionResponseDTO(
        Long id,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        VehiculoSimpleDTO vehiculoSimpleDTO,
        VehiculoSummaryDto.ConductorSimpleDto conductorSimpleDto
) {
    public record VehiculoSimpleDTO(Long id, String matricula){}

    public static AsignacionResponseDTO of(Asignacion a){
        return new AsignacionResponseDTO(
                a.getId(),
                a.getFechaInicio(),
                a.getFechaFin(),
                new VehiculoSimpleDTO(a.getVehiculo().getId(), a.getVehiculo().getMatricula()),
                new VehiculoSummaryDto.ConductorSimpleDto(a.getConductor().getId(), a.getConductor().getNombre())
        );
    }
}
