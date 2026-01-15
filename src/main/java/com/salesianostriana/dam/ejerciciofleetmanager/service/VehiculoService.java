package com.salesianostriana.dam.ejerciciofleetmanager.service;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;
import com.salesianostriana.dam.ejerciciofleetmanager.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public Page<Vehiculo> mostrarVehiculo(Pageable pageable){
        return vehiculoRepository.findVehiculos(pageable);
    }

    public Vehiculo getById(Long id){
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehiculo con id %d no encontrado".formatted(id))
                );
    }

    public boolean comprobarEstado(Long id, Estado estado){
        return vehiculoRepository.existsByIdAndEstado(id, estado);
    }

    public boolean comprobarMatricula(String matricula){
        return vehiculoRepository.existsByMatricula(matricula);
    }
}
