package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Mantenimiento;

import java.time.LocalDate;

public record MantenimientoDetailDto(
        Long id,
        String tipo,
        LocalDate fecha,
        double kmEnRevision,
        AsignacionResponseDTO.VehiculoSimpleDTO vehiculoSimpleDTO,
        TallerSimpleDto tallerSimpleDto
) {
    public record TallerSimpleDto(Long id, String nombre){}

    public static MantenimientoDetailDto of(Mantenimiento m){
        return new MantenimientoDetailDto(
                m.getId(),
                m.getTipo(),
                m.getFecha(),
                m.getKmEnRevision(),
                new AsignacionResponseDTO.VehiculoSimpleDTO(m.getVehiculo().getId(), m.getVehiculo().getMatricula()),
                new TallerSimpleDto(m.getTaller().getId(), m.getTaller().getNombre())
        );
    }
}
