package com.example.demo.controller;

import com.example.demo.domain.Libro;
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
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class EquipoControllerTest {
    @Autowired
    private MockMvc mockMvc;
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
    @Test
    public void testEliminarEquipoBadRequest() throws Exception {
        mockMvc.perform(delete("/equipos/delete")).andExpect(status().isMethodNotAllowed());
    }
}

