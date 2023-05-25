package com.example.demo.repository;


import com.example.demo.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipoRepository extends JpaRepository <Libro,Long>{
    @Query("SELECT e FROM Equipo e WHERE NOT EXISTS "
            + "(SELECT 1 FROM Usuario u JOIN u.equipos_participe ep WHERE ep.id = e.id AND u.id = :userId)")
    List<Libro> buscarEquiposDisponibles(@Param("userId") Long userId);
}
