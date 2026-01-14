package com.salesianostriana.dam.ejerciciofleetmanager.repository;

import com.salesianostriana.dam.ejerciciofleetmanager.model.Mantenimiento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {

    List<Mantenimiento> findByVehiculoId(Long vehiculoId);

    @Query("select m from mantenimiento m where m.vehiculo.id = :vehiculoId order by m.fecha desc")
    List<Mantenimiento> findUltimoMantenimiento(Long vehiculoId, Pageable pageable);
}
