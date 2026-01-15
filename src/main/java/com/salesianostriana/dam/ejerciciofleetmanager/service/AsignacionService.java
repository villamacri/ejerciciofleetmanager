package com.salesianostriana.dam.ejerciciofleetmanager.service;

import com.salesianostriana.dam.ejerciciofleetmanager.dto.CreateAsignacionRequest;
import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Asignacion;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Conductor;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;
import com.salesianostriana.dam.ejerciciofleetmanager.repository.AsignacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;
    private final VehiculoService vehiculoService;
    private final ConductorService conductorService;

    public Asignacion asignarVehiculo(CreateAsignacionRequest asigRequest){
        Vehiculo vehiculo = vehiculoService.getById(asigRequest.vehiculoId());

        Conductor conductor = conductorService.getById(asigRequest.conductorId());

        if(asignacionRepository.existsByVehiculoIdAndFechaFinIsNull(vehiculo.getId()))
            throw new IllegalArgumentException("Este vehiculo ya está asignado");

        if(asignacionRepository.existsByConductorIdAndFechaFinIsNull(conductor.getId()))
            throw new IllegalArgumentException("Este conductor ya está asignado");

        vehiculo.setEstado(Estado.ASIGNADO);
        Asignacion asignacion = toEntity(asigRequest, vehiculo, conductor);

        vehiculo.addAsignacion(asignacion);
        conductor.addAsignacion(asignacion);
        return asignacionRepository.save(asignacion);
    }

    public Asignacion cerrarAsignacion(Long asignacionId, LocalDate fechaFin){
        Asignacion asignacion = asignacionRepository.findById(asignacionId).orElseThrow(
                () -> new EntityNotFoundException("No existe asignación con id %d".formatted(asignacionId))
        );
        Vehiculo v = vehiculoService.getById(asignacion.getVehiculo().getId());

        if(asignacion.getFechaFin()!=null) throw new IllegalArgumentException("La asignación ya está cerrada");

        asignacion.setFechaFin(fechaFin);
        v.setEstado(Estado.DISPONIBLE);

        return asignacionRepository.save(asignacion);
    }

    public Asignacion toEntity(CreateAsignacionRequest asig, Vehiculo vehiculo, Conductor conductor){
        return Asignacion.builder()
                .fechaInicio(asig.fechaInicio())
                .vehiculo(vehiculo)
                .conductor(conductor)
                .build();
    }
}
