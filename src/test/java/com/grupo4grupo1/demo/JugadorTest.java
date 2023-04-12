package com.grupo4grupo1.demo;

import com.grupo4grupo1.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JugadorTest {

  @Autowired
  UsuarioRepository userRepository;

}
