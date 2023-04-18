package com.grupo4grupo1.demo;

import com.grupo4grupo1.demo.model.Equipo;
import com.grupo4grupo1.demo.model.Usuario;
import com.grupo4grupo1.demo.repository.EquipoRepository;
import com.grupo4grupo1.demo.repository.UsuarioRepository;
import com.grupo4grupo1.demo.service.EquipoService;
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
    equipoService.remove(1L);

    // Verifica si el equipo fue eliminado correctamente
    Optional<Equipo> equipoAux = equipoRepository.findById(1L);
    Assertions.assertTrue(equipoAux.isPresent(), "El equipo todavia existe");
    Assertions.assertTrue(equipoAux.get().isEliminado(), "La eliminación lógica se realizó correctamente");
  }
}
