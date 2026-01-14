package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Mantenimiento;

import java.time.LocalDate;

public record CreateMantenimientoRequest(
        String tipo,
        LocalDate fecha,
        int kmEnRevision
) {
    public Mantenimiento toEntity(){
        return Mantenimiento.builder()
                .tipo(this.tipo)
                .fecha(this.fecha)
                .kmEnRevision(this.kmEnRevision)
                .build();
    }
}
