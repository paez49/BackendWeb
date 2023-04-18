package com.grupo4grupo1.demo.service;

import com.grupo4grupo1.demo.model.Equipo;
import com.grupo4grupo1.demo.repository.EquipoRepository;
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
}
