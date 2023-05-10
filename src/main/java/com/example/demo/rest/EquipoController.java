package com.example.demo.rest;


import com.example.demo.domain.Equipo;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.service.EquipoService;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {
    @Autowired
    EquipoRepository equipoRepository;
    @Autowired
    EquipoService equipoService;
    @Autowired
    private ConverterDTO converterDTO;
    //Obtener todos los equipos
    @GetMapping("/all")
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> obtenerEquipo(@PathVariable Long id) {
        Equipo equipo = equipoService.findById(id);
        if (equipo == null) {
            return ResponseEntity.notFound().build();
        }
        EquipoDTO equipoDTO = converterDTO.toDto(equipo);
        return ResponseEntity.ok(equipoDTO);
    }



}
