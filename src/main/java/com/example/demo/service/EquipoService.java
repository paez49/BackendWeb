package com.example.demo.service;


import com.example.demo.domain.Equipo;
import com.example.demo.domain.Invitacion;
import com.example.demo.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EquipoService {

  @Autowired
  private EquipoRepository equipoRepository;

  public Equipo create(Equipo equipo) {
    return equipoRepository.save(equipo);
  }

  public void remove(Long id){
    Optional<Equipo> equipoOptional = equipoRepository.findById(id);
    if (equipoOptional.isPresent()) {
      Equipo equipo = equipoOptional.get();
      equipo.setEliminado(true); // establecer el valor de "eliminado" a false
      equipoRepository.save(equipo); // guardar el objeto actualizado en la base de datos
    }
  }
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
  public void agregarInvitacion(Invitacion invitacion){

  }
}
