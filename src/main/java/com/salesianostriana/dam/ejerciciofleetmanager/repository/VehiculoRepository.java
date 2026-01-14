package com.salesianostriana.dam.ejerciciofleetmanager.repository;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    List<Vehiculo> findByEstado(Estado estado);

    boolean existsByMatricula(String matricula);

    @EntityGraph(attributePaths = {"asignaciones"})
    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findAllWithAsignaciones();

    Optional<Vehiculo> findByMatricula(String Matricula);
}
