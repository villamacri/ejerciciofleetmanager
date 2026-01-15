package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Asignacion;

import java.time.LocalDate;

public record CreateAsignacionRequest(
        LocalDate fechaInicio,
        LocalDate fechaFin,
        Long vehiculoId,
        Long conductorId
) {

}
