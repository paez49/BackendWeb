package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Equipo;

public interface EquipoRepository extends JpaRepository <Equipo,Long>{
    
}
