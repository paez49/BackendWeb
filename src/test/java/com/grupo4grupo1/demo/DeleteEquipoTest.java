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

@Transactional
@SpringBootTest

public class DeleteEquipoTest {
  @Autowired
  private EquipoRepository equipoRepository;
  @Autowired
  private EquipoService equipoService;
  @Autowired
  private UsuarioRepository usuarioRepository;
  @Test
  public void testDeleteByIdLogic() {
    // Elimina el equipo con deleteByIdLogic
    Equipo equipo = new Equipo();
    equipo.setNombreEquipo("Eskere FC");
    equipo.setSiglas("EFC");
    equipoRepository.save(equipo);
    equipoService.remove((long)1);

    Optional<Equipo> equipoAux = equipoRepository.findById((long)1);
    try {
      // Si se encuentra el equipo, la prueba fallará
      Assertions.assertFalse(equipoAux.isPresent());
    } catch (NoSuchElementException e) {
      Assertions.assertTrue(true);
    }


  }
}
