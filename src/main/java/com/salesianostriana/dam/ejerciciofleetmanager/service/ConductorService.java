package com.salesianostriana.dam.ejerciciofleetmanager.service;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Conductor;
import com.salesianostriana.dam.ejerciciofleetmanager.repository.ConductorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConductorService {

    private final ConductorRepository conductorRepository;

    public Conductor getById(Long id){
        return conductorRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado conductor con id %d".formatted(id))
        );
    }

    public List<Conductor> mostrarConductoresConVehiculosDisponibles(){
        return conductorRepository.findByVehiculoEstado(Estado.DISPONIBLE);
    }
}
