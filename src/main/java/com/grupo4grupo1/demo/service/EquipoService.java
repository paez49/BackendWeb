package com.grupo4grupo1.demo.service;

import com.grupo4grupo1.demo.model.Equipo;
import com.grupo4grupo1.demo.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {

  @Autowired
  private EquipoRepository equipoRepository;

  public Equipo create(Equipo equipo) {
    return equipoRepository.save(equipo);
  }

  public void remove(Long id){
    equipoRepository.deleteById(id);
  }

  public Iterable<Equipo> findAll(){
    return equipoRepository.findAll();
  }
}
