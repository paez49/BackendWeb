package com.example.demo.rest;


import com.example.demo.domain.Invitacion;
import com.example.demo.dto.InvitacionDTO;
import com.example.demo.security.payload.MessageResponse;
import com.example.demo.service.InvitacionService;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invitaciones")
public class InvitacionController {
    @Autowired
    private InvitacionService invitacionService;
    @Autowired
    private ConverterDTO converterDTO;
    //Obtener todas las invitaciones de un usuario
    //Mis invitaciones -> Presentacion lista invitaciones
    @GetMapping("/get/{idUsuario}")
    public ResponseEntity<List<InvitacionDTO>> obtenerTodasLasInvitaciones(@PathVariable Long idUsuario) {
        List<InvitacionDTO> invitaciones = converterDTO.toDtoListInvitaciones(invitacionService.obtenerInvitacionesPorIdUsuario(idUsuario));
        return ResponseEntity.ok().body(invitaciones);
    }
    //Rechazar invitacion
    //Mis invitaciones -> Boton rechazar
    @DeleteMapping("/deny/{idInvitacion}")
    public ResponseEntity<?> rechazarInvitacion(@PathVariable Long idInvitacion){
        try{
            invitacionService.rechazarInvitacion(idInvitacion);
            return ResponseEntity.ok().body("Invitacion rechazada");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al rechazar invitacion");
        }
    }
    @PutMapping("/accept")
    public ResponseEntity<?> aceptarInvitacion(@RequestBody InvitacionDTO invitacion){
        try{
            invitacionService.aceptarInvitacion(invitacion);
            return ResponseEntity.ok().body("Invitacion aceptada");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error al aceptar invitacion");
        }
    }
  @PostMapping("/add")
  public ResponseEntity<?> crearSolicitud(@RequestBody Long idUsuario, @RequestBody Long idEquipo) {
    try {
      invitacionService.crearInvitacion(idEquipo , idUsuario);
      return ResponseEntity.ok(new MessageResponse("Solicitud enviada con exito"));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Ya hay una solicitud registrada para este equipo"));
    }
  }
}
