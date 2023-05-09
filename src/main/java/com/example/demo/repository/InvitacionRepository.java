package com.example.demo.repository;

import com.example.demo.domain.Invitacion;
import com.example.demo.domain.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitacionRepository extends JpaRepository<Invitacion,Long>{
    List<Invitacion> findByUsuarioId(Long idUsuario);
}
