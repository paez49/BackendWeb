package com.example.demo.rest;

import com.example.demo.domain.Solicitud;
import com.example.demo.dto.SolicitudDTO;
import com.example.demo.dto.SolicitudDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.security.payload.MessageResponse;
import com.example.demo.service.SolicitudService;
import com.example.demo.service.UsuarioService;
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
    UsuarioService usuarioService;
    @Autowired
    private ConverterDTO converterDTO;

    //Crear solicitud
    //Lista solicitudes -> Boton enviar solicitud
    @PostMapping("/add")
    public ResponseEntity<?> crearSolicitud(@RequestBody Long idUsuario, @RequestBody Long idEquipo) {
        try {
            solicitudService.crearSolicitud(idUsuario, idEquipo);
            return ResponseEntity.ok(new MessageResponse("Solicitud enviada con exito"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ya hay una solicitud registrada para este equipo"));
        }
    }
    //Mostrar todas las solicitudes
    //Equipos -> Solicitudes pendientes
    @GetMapping("/get/{idEquipo}")
    public ResponseEntity<List<SolicitudDTO>> obtenerTodasLasSolicitudes(@PathVariable Long idEquipo) {
        List<SolicitudDTO> solicitudes = converterDTO.toDtoListSolicitudes(solicitudService.obtenerSolcitudesPorIdEquipo(idEquipo));
        return ResponseEntity.ok().body(solicitudes);
    }
    //Equipos -> Solicitudes pendientes -> Boton eliminar
    @DeleteMapping("/deny/{idSolicitud}")
    public ResponseEntity<?> rechazarSolicitud(@PathVariable Long idSolicitud){
        try{
            solicitudService.rechazarSolicitud(idSolicitud);
            return ResponseEntity.ok().body("Solicitud rechazada");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al rechazar Solicitud");
        }
    }
    //Equipos -> Solicitudes pendientes -> Boton aceptar
    @PutMapping("/accept")
    public ResponseEntity<?> aceptarSolicitud(@RequestBody SolicitudDTO solicitud){
        try{
            solicitudService.aceptarSolicitud(solicitud);
            return ResponseEntity.ok().body("Solicitud aceptada");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al aceptar Solicitud");
        }
    }

}
