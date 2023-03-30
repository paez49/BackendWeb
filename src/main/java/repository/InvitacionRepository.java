package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Invitacion;

public interface InvitacionRepository extends JpaRepository<Invitacion,Long>{
    
}
