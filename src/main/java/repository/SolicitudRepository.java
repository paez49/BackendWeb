package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud,Long>{
    
}
