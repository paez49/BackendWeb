package com.grupo4grupo1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4grupo1.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
