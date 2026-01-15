package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Conductor;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;

import java.time.LocalDate;

public record VehiculoDetailDto(
        Long id,
        String matricula,
        String modelo,
        Estado estado,
        ConductorSimpleDto conductorSimpleDto,
        AsignacionSimpleDto asignacionSimpleDto,
        MantenimientoSimpleDto mantenimientoSimpleDto
) {
    public record ConductorSimpleDto(Long id, String nombre){}

    public record AsignacionSimpleDto(Long id, LocalDate fechaInicio){}

    public record MantenimientoSimpleDto(Long id, String tipo, LocalDate fecha){}

}
