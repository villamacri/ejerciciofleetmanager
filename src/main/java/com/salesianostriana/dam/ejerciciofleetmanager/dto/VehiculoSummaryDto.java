package com.salesianostriana.dam.ejerciciofleetmanager.dto;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Asignacion;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Conductor;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;

public record VehiculoSummaryDto(
        String matricula,
        String modelo
) {
    public record AsignacionInfo(Long id, Conductor conductor)
    public static VehiculoSummaryDto of(Vehiculo vehiculo){
        return new VehiculoSummaryDto(
                vehiculo.getMatricula(),
                vehiculo.getModelo()
         );
    }
}
