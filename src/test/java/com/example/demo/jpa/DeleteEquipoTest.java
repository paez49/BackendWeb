package com.example.demo.jpa;

import com.example.demo.domain.Equipo;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.service.EquipoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@Transactional
@SpringBootTest

public class DeleteEquipoTest {
  @Autowired
  private EquipoRepository equipoRepository;
  @Autowired
  private EquipoService equipoService;

  @Test
  @Transactional
  public void testDeleteByIdLogic() {
    // Elimina el equipo con deleteByIdLogic
    equipoService.delete(1L);

    // Verifica si el equipo fue eliminado correctamente
    Optional<Equipo> equipoAux = equipoRepository.findById(1L);
    Assertions.assertTrue(equipoAux.isEmpty(), "El equipo se borró con exito");
    //Assertions.assertTrue(equipoAux.get().isEliminado(), "La eliminación lógica se realizó correctamente");
  }
}
