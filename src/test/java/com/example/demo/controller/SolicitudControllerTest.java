package com.example.demo.controller;

import com.example.demo.security.payload.MessageResponse;
import com.example.demo.service.SolicitudService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class SolicitudControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private SolicitudService solicitudService;
    @Test
    public void testCrearSolicitud() throws Exception {
        // Datos de prueba
        Long idUsuario = 1L;
        Long idEquipo = 2L;

        // Simular la creación exitosa de una invitación
        doNothing().when(solicitudService).crearSolicitud(idUsuario, idEquipo);

        // Realizar la solicitud HTTP POST a la ruta del controlador
        mockMvc.perform(MockMvcRequestBuilders.post("/solicitudes/add/user={idUsuario}/equipo={idEquipo}", idUsuario, idEquipo)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Solicitud enviada con exito"));
    }
    @Test
    public void testCrearSolicitud_SolicitudExistente() throws Exception {
        // Datos de prueba
        Long idUsuario = 1L;
        Long idEquipo = 2L;

        // Simular una excepción cuando ya hay una solicitud registrada para el equipo
        MessageResponse badResponse = new MessageResponse("Ya hay una solicitud registrada para este equipo");


        // Realizar la solicitud HTTP POST a la ruta del controlador
        mockMvc.perform(MockMvcRequestBuilders.post("/solicitudes/add/user={idUsuario}/equipo={idEquipo}", idUsuario, idEquipo)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("Ya hay una solicitud registrada para este equipo"));
    }
    
}
