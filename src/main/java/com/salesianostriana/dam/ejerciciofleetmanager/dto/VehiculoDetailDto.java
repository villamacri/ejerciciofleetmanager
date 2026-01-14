package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;

public record VehiculoDetailDto(
        String matricula,
        String modelo,
        int kmActuales,
        Estado estado
) {
    public static VehiculoDetailDto of(Vehiculo vehiculo){
        return new VehiculoDetailDto(
                vehiculo.getMatricula(),
                vehiculo.getModelo(),
                vehiculo.getKmActuales(),
                vehiculo.getEstado()
        );
    }
}
