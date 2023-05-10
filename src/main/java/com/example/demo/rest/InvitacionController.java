package com.example.demo.rest;


import com.example.demo.domain.Invitacion;
import com.example.demo.dto.InvitacionDTO;
import com.example.demo.service.InvitacionService;
import com.example.demo.util.ConverterDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    /*
    @PostMapping("/agregar/{equipoId}/{usuarioId}")
    public void crearInvitacion(@PathVariable Long equipoId, @PathVariable Long usuarioId) {
         invitacionService.crearInvitacion(equipoId, usuarioId);
    }*/
    @GetMapping("/get/{idUsuario}")
    public ResponseEntity<List<InvitacionDTO>> obtenerTodasLasInvitacionesPorIdUsuario(@PathVariable Long idUsuario) {
        List<InvitacionDTO> invitaciones = converterDTO.toDtoListInvitaciones(invitacionService.obtenerInvitacionesPorIdUsuario(idUsuario));


}
