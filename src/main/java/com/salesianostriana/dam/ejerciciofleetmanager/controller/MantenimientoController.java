package com.salesianostriana.dam.ejerciciofleetmanager.controller;

import com.salesianostriana.dam.ejerciciofleetmanager.dto.CreateMantenimientoRequest;
import com.salesianostriana.dam.ejerciciofleetmanager.dto.MantenimientoDetailDto;
import com.salesianostriana.dam.ejerciciofleetmanager.service.MantenimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mantenimientos")
public class MantenimientoController {

    private final MantenimientoService mantenimientoService;

    @PostMapping()
    public MantenimientoDetailDto registrarMantenimiento(CreateMantenimientoRequest mantenimientoRequest){
        return MantenimientoDetailDto.of(mantenimientoService.registrarMantenimiento(mantenimientoRequest));
    }
}
