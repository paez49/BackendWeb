package com.example.demo.service;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

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
}
