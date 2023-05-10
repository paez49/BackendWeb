package com.example.demo.rest;

import com.example.demo.domain.Solicitud;
import com.example.demo.dto.InvitacionDTO;
import com.example.demo.dto.SolicitudDTO;
import com.example.demo.security.payload.MessageResponse;
import com.example.demo.service.SolicitudService;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    SolicitudService solicitudService;
    @Autowired
    private ConverterDTO converterDTO;

    //Crear solicitud
    //Lista solicitudes -> Boton enviar solicitud
    @PostMapping("/add")
    public ResponseEntity<?> crearSolicitud(@RequestParam Long idUsuario, @RequestParam Long idEquipo) {
        try {
            solicitudService.crearSolicitud(idUsuario, idEquipo);
            return ResponseEntity.ok(new MessageResponse("Solicitud enviada con exito"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ya hay una solicitud registrada para este equipo"));
        }
    }
    //Mostrar todas las solicitudes
    //Equipos -> Invitaciones pendientes
    @GetMapping("/get/{idUsuario}")
    public ResponseEntity<List<SolicitudDTO>> obtenerSolicitudesPorIdUsuario(@PathVariable Long idUsuario) {
            List<SolicitudDTO> solicitudes = converterDTO.toDtoListSolicitudes(solicitudService.obtenerSolcitudesPorIdUsuario(idUsuario));
            return ResponseEntity.ok().body(solicitudes);
    }

}
