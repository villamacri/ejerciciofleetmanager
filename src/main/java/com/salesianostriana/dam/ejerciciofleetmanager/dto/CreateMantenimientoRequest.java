package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Mantenimiento;

import java.time.LocalDate;

public record CreateMantenimientoRequest(
        String tipo,
        LocalDate fecha,
        int kmEnRevision,
        Long vehiculoId,
        Long tallerId
) {
}
