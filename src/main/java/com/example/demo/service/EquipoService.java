package com.example.demo.service;


import com.example.demo.domain.Equipo;
import com.example.demo.domain.Invitacion;
import com.example.demo.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

  @Autowired
  private EquipoRepository equipoRepository;

  public Iterable<Equipo> findAll(){
    return equipoRepository.findAll();
  }
  public Equipo findById(Long id) {
    Optional<Equipo> equipoOptional = equipoRepository.findById(id);
    return equipoOptional.orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
  }
  public Equipo save(Equipo equipo) {
    return equipoRepository.save(equipo);
  }
  public List<Equipo> buscarEquiposDisponibles(Long idUsuario){
    return equipoRepository.buscarEquiposDisponibles(idUsuario);
  }
}
