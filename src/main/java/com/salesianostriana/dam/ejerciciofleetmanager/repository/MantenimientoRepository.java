package com.salesianostriana.dam.ejerciciofleetmanager.repository;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
}
