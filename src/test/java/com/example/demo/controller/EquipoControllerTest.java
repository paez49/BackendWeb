package com.example.demo.controller;

import com.example.demo.domain.Equipo;
import com.example.demo.domain.Invitacion;
import com.example.demo.domain.Solicitud;
import com.example.demo.dto.EquipoDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.rest.EquipoController;
import com.example.demo.service.EquipoService;
import com.example.demo.util.ConverterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class EquipoControllerTest {

    @Mock
    private EquipoService equipoService;

    @InjectMocks
    private EquipoController equipoController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ConverterDTO converterDTO = new ConverterDTO();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEliminarEquipo() throws Exception {
        mockMvc.perform(delete("/equipos/delete/{idEquipo}", 12L))
                .andExpect(status().isOk());
    }
    @Test
    public void testAgregarEquipo() throws Exception {
        mockMvc.perform(post("/equipos/create")
                .contentType("application/json")
                .content("{\"nombreEquipo\":\"Equipo 1\",\"siglas\":\"EQ1\"}"))
                .andExpect(status().isCreated());
    }

}

