package com.salesianostriana.dam.ejerciciofleetmanager.service;

import com.salesianostriana.dam.ejerciciofleetmanager.dto.CreateMantenimientoRequest;
import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Mantenimiento;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Taller;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;
import com.salesianostriana.dam.ejerciciofleetmanager.repository.MantenimientoRepository;
import com.salesianostriana.dam.ejerciciofleetmanager.repository.TallerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final VehiculoService vehiculoService;
    private final TallerRepository tallerRepository;

    public Mantenimiento registrarMantenimiento(CreateMantenimientoRequest mantDto){

        Vehiculo vehiculo = vehiculoService.getById(mantDto.vehiculoId());

        Taller taller = tallerRepository.findById(mantDto.tallerId()).orElseThrow(
                () -> new EntityNotFoundException("No existe un taller con id %d".formatted(mantDto.tallerId()))
        );

        if(vehiculoService.comprobarEstado(vehiculo.getId(), Estado.ASIGNADO))
            throw new IllegalArgumentException("El vehículo está asignado");

        if(mantDto.kmEnRevision()< vehiculo.getKmActuales())
            throw new IllegalArgumentException("El kilometraje del mantenimiento debe ser igual o mayor al actual");

        Mantenimiento mantenimiento = toEntity(mantDto, vehiculo, taller);

        vehiculo.setKmActuales(mantenimiento.getKmEnRevision());
        vehiculo.addMantenimiento(mantenimiento);
        taller.addMantenimento(mantenimiento);
        return mantenimientoRepository.save(mantenimiento);
    }

    public Mantenimiento toEntity(CreateMantenimientoRequest mant, Vehiculo v, Taller t){
        return Mantenimiento.builder()
                .tipo(mant.tipo())
                .fecha(mant.fecha())
                .kmEnRevision(mant.kmEnRevision())
                .vehiculo(v)
                .taller(t)
                .build();
    }
}
