package com.grupo4grupo1.demo.rest;

import java.util.List;

import com.grupo4grupo1.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4grupo1.demo.service.UsuarioService;

@RestController
@RequestMapping ("/usuario/")
public class UsuarioRest {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<List<Usuario>> getAllUsuarios(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
}
