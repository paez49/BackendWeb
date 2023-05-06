package com.example.demo.rest;


import com.example.demo.domain.Equipo;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EquipoController {
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    EquipoService equipoService;
    @GetMapping("/equipos")
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }
    @GetMapping("/equipos/{id}")
    public ResponseEntity<Equipo> obtenerEquipo(@PathVariable Long id) {
        Equipo equipo = equipoService.findById(id);
        if (equipo == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(equipo.getSolicitudes_de_jugadores().toString());
        return ResponseEntity.ok(equipo);
    }

}
