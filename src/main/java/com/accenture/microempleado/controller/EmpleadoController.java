package com.accenture.microempleado.controller;


import com.accenture.microempleado.model.Empleado;
import com.accenture.microempleado.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    @ResponseBody
    public List<Object> showAll(){
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("{id}")
    @ResponseBody
    public Object getEmpleado(@PathVariable("id") Long id){
        return empleadoService.getOneEmpleado(id);
    }

    @PostMapping
    @ResponseBody
    public Empleado createEmpleado(@RequestBody Empleado empleado){
        return empleadoService.saveEmpleado(empleado);
    }

}

