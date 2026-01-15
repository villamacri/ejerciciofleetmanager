package com.salesianostriana.dam.ejerciciofleetmanager.controller;

import com.salesianostriana.dam.ejerciciofleetmanager.dto.VehiculoSummaryDto;
import com.salesianostriana.dam.ejerciciofleetmanager.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping()
    public Page<VehiculoSummaryDto> mostrarVehiculos(@PageableDefault(value = 10, size = 20)Pageable pageable){
        return vehiculoService.mostrarVehiculo(pageable).map(VehiculoSummaryDto::of);
    }
}
