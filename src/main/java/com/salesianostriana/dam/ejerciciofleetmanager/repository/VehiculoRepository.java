package com.salesianostriana.dam.ejerciciofleetmanager.repository;

import com.salesianostriana.dam.ejerciciofleetmanager.enums.Estado;
import com.salesianostriana.dam.ejerciciofleetmanager.model.Vehiculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    boolean existsByIdAndEstado(Long id, Estado estado);
    boolean existsByMatricula(String matricula);

    @EntityGraph(attributePaths = {"conductor"})
    List<Vehiculo> findByEstado(Estado estado);

    @EntityGraph(attributePaths = {"conductor"})
    @Query("select v from Vehiculo v")
    Page<Vehiculo> findVehiculos(Pageable pageable);

    @EntityGraph(attributePaths = {"conductor", "asignaciones", "mantenimientos"})
    @Query("select v from Vehiculo v where v.conductor.id = ?1 and v.estado = ?2")
    Vehiculo findByConductorIdAndEstado(Long id, Estado estado);

}
