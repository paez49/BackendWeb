package com.example.demo.rest;

import com.example.demo.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    SolicitudService solicitudService;
    @PostMapping("/add")
    public ResponseEntity<?> crearSolicitud(@RequestParam Long idUsuario, @RequestParam Long idEquipo) {
        solicitudService.crearSolicitud(idUsuario, idEquipo);
        return ResponseEntity.ok().build();
    }
}
