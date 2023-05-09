package com.example.demo.rest;

import com.example.demo.security.payload.MessageResponse;
import com.example.demo.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SolicitudController {
    @Autowired
    SolicitudService solicitudService;

    //Crear solicitud
    //Lista solicitudes -> Boton enviar solicitud
    @PostMapping("/solicitudes")
    public ResponseEntity<?> crearSolicitud(@RequestParam Long idUsuario, @RequestParam Long idEquipo) {
        try {
            solicitudService.crearSolicitud(idUsuario, idEquipo);
            return ResponseEntity.ok(new MessageResponse("Solicitud enviada con exito"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error al enviar solicitud"));
        }
    }

}
