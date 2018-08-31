package com.accenture.microempleado.controller;


import com.accenture.microempleado.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;




}

