package com.grupo4grupo1.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo4grupo1.demo.service.InvitacionService;

@RestController
@RequestMapping ("/solicitud/")
public class InvitacionRest {
    @Autowired
    InvitacionService invitacionService;
}
