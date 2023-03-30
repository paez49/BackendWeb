package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.SolicitudService;

@RestController
@RequestMapping ("/solicitud/")
public class SolicitudRest {
    @Autowired
    SolicitudService solicitudService;
}
