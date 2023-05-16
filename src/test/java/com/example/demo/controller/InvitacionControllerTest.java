package com.example.demo.controller;

import com.example.demo.service.InvitacionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class InvitacionControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private InvitacionService invitacionService;
    @Test
    public void testCrearInvitacionBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/invitaciones/add/user=1/equipo=f")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testCrearInvitacion() throws Exception {
        // Datos de prueba
        Long idUsuario = 1L;
        Long idEquipo = 2L;

        // Simular la creación exitosa de una invitación
        doNothing().when(invitacionService).crearInvitacion(idEquipo, idUsuario);

        // Realizar la solicitud HTTP POST a la ruta del controlador
        mockMvc.perform(MockMvcRequestBuilders.post("/invitaciones/add/user={idUsuario}/equipo={idEquipo}", idUsuario, idEquipo)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Invitacion enviada con exito"));
    }

}
