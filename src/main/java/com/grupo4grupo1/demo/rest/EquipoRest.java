package com.grupo4grupo1.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4grupo1.demo.model.Equipo;
import com.grupo4grupo1.demo.service.EquipoService;

@RestController
@RequestMapping ("/equipo/")
public class EquipoRest {
    @Autowired
    private EquipoService equipoService;
    @GetMapping
    private ResponseEntity<List<Equipo>> getAllEquipos(){
        return ResponseEntity.ok(equipoService.findAll());
    }
}
