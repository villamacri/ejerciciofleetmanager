package com.salesianostriana.dam.ejerciciofleetmanager.controller;

import com.salesianostriana.dam.ejerciciofleetmanager.dto.AsignacionResponseDTO;
import com.salesianostriana.dam.ejerciciofleetmanager.dto.CreateAsignacionRequest;
import com.salesianostriana.dam.ejerciciofleetmanager.service.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    private final AsignacionService asignacionService;

    @PostMapping()
    public AsignacionResponseDTO createAsignacion(@RequestParam CreateAsignacionRequest asignacionRequest){
        return AsignacionResponseDTO.of(asignacionService.asignarVehiculo(asignacionRequest));
    }

    @PutMapping("/{id}/cerrar")
    public AsignacionResponseDTO cerrarAsignacion(@PathVariable Long id, LocalDate fechaFin){
        return AsignacionResponseDTO.of(asignacionService.cerrarAsignacion(id, fechaFin));
    }
}
