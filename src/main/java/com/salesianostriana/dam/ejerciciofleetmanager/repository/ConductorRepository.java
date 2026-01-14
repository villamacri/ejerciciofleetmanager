package com.salesianostriana.dam.ejerciciofleetmanager.repository;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}
