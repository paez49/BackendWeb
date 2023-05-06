package com.example.demo.rest;


import com.example.demo.domain.Invitacion;
import com.example.demo.service.InvitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invitacion")
public class InvitacionController {
    @Autowired
    private InvitacionService invitacionService;

    @PostMapping("/agregar/{equipoId}/{usuarioId}")
    public void crearInvitacion(@PathVariable Long equipoId, @PathVariable Long usuarioId) {
         invitacionService.crearInvitacion(equipoId, usuarioId);
    }
    @GetMapping("/invitaciones")
    public ResponseEntity<List<Invitacion>> obtenerTodasLasInvitaciones() {
        List<Invitacion> invitaciones = (List<Invitacion>) invitacionService.findAll();
        return ResponseEntity.ok().body(invitaciones);
    }
}
