package com.salesianostriana.dam.ejerciciofleetmanager.repository;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
