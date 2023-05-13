package com.example.demo.service;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Solicitud;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EquipoService equipoService;

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public Iterable<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }
    public void agregarUsuarioEquipo(UsuarioDTO usuarioDTO, EquipoDTO equipoDTO) {
        Usuario usuario = findById(usuarioDTO.getId());
        Equipo equipo = equipoService.findById(equipoDTO.getId());
        usuario.getEquipos_participe().add(equipo);
        usuarioRepository.save(usuario);
    }

}
