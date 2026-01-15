package com.salesianostriana.dam.ejerciciofleetmanager.repository;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Mantenimiento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {

    @EntityGraph(attributePaths = {"vehiculo"})
    List<Mantenimiento> findByVehiculoId(Long id);

    @EntityGraph(attributePaths = {"vehiculo", "taller"})
    @Query("select m from Mantenimiento m where m.vehiculo.id = ?1 order by m.fecha DESC")
    Optional<Mantenimiento> findVehiculoIdOrderByFechaDesc(Long id);
}
