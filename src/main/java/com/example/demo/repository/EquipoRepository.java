package com.example.demo.repository;


import com.example.demo.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipoRepository extends JpaRepository <Equipo,Long>{
    @Query(value = "SELECT e.* " +
            "FROM Equipo e " +
            "WHERE e.eliminado = false " +
            "AND NOT EXISTS ( " +
            "  SELECT 1 " +
            "  FROM jugadores_en_equipo je " +
            "  WHERE je.id_equipo = e.id " +
            "  AND je.id_usuario = :idUsuario " +
            ")", nativeQuery = true)
    List<Equipo> buscarEquiposDisponibles(@Param("idUsuario") Long idUsuario);
}
