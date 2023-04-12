package com.grupo4grupo1.demo;

import com.grupo4grupo1.demo.model.Usuario;
import com.grupo4grupo1.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JugadorTest {

  @Autowired
  UsuarioRepository userRepository;
  @Test
  public void pruebaInsercionUsuario(){
    try{
      Usuario usuario = new Usuario();

      usuario.setNombre("Juan");
      usuario.setApellido("Paez");
      usuario.setCorreo("juan@paez.com");

      userRepository.save(usuario);
    }
    catch (Exception e){
      e.printStackTrace();
      assertTrue( false, "Error en la aplicación" );

    }
  }
}
