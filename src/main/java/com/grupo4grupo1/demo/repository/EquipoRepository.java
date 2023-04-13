package com.grupo4grupo1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo4grupo1.demo.model.Equipo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EquipoRepository extends JpaRepository <Equipo,Long>{
}
