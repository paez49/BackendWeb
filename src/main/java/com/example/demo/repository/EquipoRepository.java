package com.example.demo.repository;


import com.example.demo.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipoRepository extends JpaRepository <Equipo,Long>{
    @Query("SELECT e FROM Equipo e WHERE NOT EXISTS "
            + "(SELECT 1 FROM Usuario u JOIN u.equipos_participe ep WHERE ep.id = e.id AND u.id = :userId)")
    List<Equipo> buscarEquiposDisponibles(@Param("userId") Long userId);
}
