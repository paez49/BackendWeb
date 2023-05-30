package com.example.demo.repository;

import com.example.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
  Optional<Usuario> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  @Query("SELECT u FROM Usuario u WHERE NOT EXISTS (SELECT 1 FROM u.equipos_participe e WHERE e.id = :idEquipo)")
  List<Usuario> findAllUsuariosNotInEquipo(@Param("idEquipo") Long idEquipo);
}
